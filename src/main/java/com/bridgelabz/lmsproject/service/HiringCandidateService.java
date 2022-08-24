package com.bridgelabz.lmsproject.service;

import com.bridgelabz.lmsproject.DTO.HiringCandidateDTO;
import com.bridgelabz.lmsproject.Repository.IHiringCandidateRepository;
import com.bridgelabz.lmsproject.exception.AdminException;
import com.bridgelabz.lmsproject.model.HiringCandidateModel;
import com.bridgelabz.lmsproject.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class HiringCandidateService implements IHiringCandidateService {
    @Autowired
    IHiringCandidateRepository hiringCandidateRepository;
    @Autowired
    TokenUtil tokenUtil;
    @Autowired
    MailService mailService;
    @Override
    public HiringCandidateModel addHiredCandidate(HiringCandidateDTO hiringCandidateDTO, String token) {
        Long candId = tokenUtil.decodeToken(token);
        HiringCandidateModel hiringCandidateModel = new HiringCandidateModel(hiringCandidateDTO);
        hiringCandidateModel.setCreationTimeStamp(LocalDateTime.now());
       hiringCandidateRepository.save(hiringCandidateModel);
        String body = "Candidate added Successfully with id  :" + hiringCandidateModel.getId();
        String subject = "Candidate added Successfully....";
        mailService.send(hiringCandidateModel.getEmail(), body, subject);
        return hiringCandidateModel;
    }

    @Override
    public List<HiringCandidateModel> getAllHiredCandidateDetails(String token) {
        Long candId = tokenUtil.decodeToken(token);
        Optional<HiringCandidateModel> isCandidatePresent = hiringCandidateRepository.findById(candId);
        if (isCandidatePresent.isPresent()){
            List<HiringCandidateModel> getAllCandidateDetails = hiringCandidateRepository.findAll();
            if (getAllCandidateDetails.size() > 0)
                return getAllCandidateDetails;
            else
                throw new AdminException(400, "No Data Found");
        }
        throw new AdminException(400, "Candidate not found");
    }

    @Override
    public HiringCandidateModel updateHiredCandidateDetails(long id, HiringCandidateDTO hiringCandidateDTO, String token) {
        Long candId = tokenUtil.decodeToken(token);
        Optional<HiringCandidateModel> isCandidatePresent = hiringCandidateRepository.findById(candId);
        if (isCandidatePresent.isPresent()){
            isCandidatePresent.get().setCicId(hiringCandidateDTO.getCicId());
            isCandidatePresent.get().setFullName(hiringCandidateDTO.getFullName());
            isCandidatePresent.get().setMobileNum(hiringCandidateDTO.getMobileNum());
            isCandidatePresent.get().setHiredData(hiringCandidateDTO.getHiredData());
            isCandidatePresent.get().setDegree(hiringCandidateDTO.getDegree());
            isCandidatePresent.get().setAggrPer(hiringCandidateDTO.getAggrPer());
            isCandidatePresent.get().setCity(hiringCandidateDTO.getCity());
            isCandidatePresent.get().setState(hiringCandidateDTO.getState());
            isCandidatePresent.get().setJobLocation(hiringCandidateDTO.getJobLocation());
            isCandidatePresent.get().setStatus(hiringCandidateDTO.getStatus());
            isCandidatePresent.get().setCreationTimeStamp(hiringCandidateDTO.getCreationTimeStamp());
            isCandidatePresent.get().setUpdatedTimeStamp(hiringCandidateDTO.getUpdatedTimeStamp());
            String body = "Candidate updated Successfully with id  :" + isCandidatePresent.get().getId();
            String subject = "Candidate updated Successfully....";
            mailService.send(isCandidatePresent.get().getEmail(), body, subject);
            return isCandidatePresent.get();
        }
        throw  new AdminException(400, "Candidate not Present");
    }

    @Override
    public HiringCandidateModel deleteHiredCandidateDetails(Long id, String token) {
        Long candId = tokenUtil.decodeToken(token);
        Optional<HiringCandidateModel> isCandidatePresent = hiringCandidateRepository.findById(candId);
        if (isCandidatePresent.isPresent()){
            hiringCandidateRepository.delete(isCandidatePresent.get());
            return isCandidatePresent.get();
        }
        throw new AdminException(400, "Candidate Not found");
    }
}
