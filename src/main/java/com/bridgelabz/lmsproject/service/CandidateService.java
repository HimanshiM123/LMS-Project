package com.bridgelabz.lmsproject.service;

import com.bridgelabz.lmsproject.DTO.CandidateDTO;
import com.bridgelabz.lmsproject.Repository.ICandidateRepository;
import com.bridgelabz.lmsproject.Repository.ITechStackRepository;
import com.bridgelabz.lmsproject.exception.AdminException;
import com.bridgelabz.lmsproject.model.CandidateModel;
import com.bridgelabz.lmsproject.model.TechStackModel;
import com.bridgelabz.lmsproject.util.Email;
import com.bridgelabz.lmsproject.util.MessageProducer;
import com.bridgelabz.lmsproject.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CandidateService implements ICandidateService {
    @Autowired
    ICandidateRepository candidateRepository;

    @Autowired
    TokenUtil tokenUtil;

    @Autowired
    MailService mailService;
    @Autowired
    ITechStackRepository techStackRepository;
    @Autowired
    Email email;
    @Autowired
    MessageProducer messageproducer;
    @Override
    public CandidateModel addCandidate(CandidateDTO candidateDTO, String token, List<Long> techStackId1) {
        List<TechStackModel> techStackModels = new ArrayList<>();
        techStackId1.stream().forEach(techStackId->{
            Optional<TechStackModel> isTechStackPresent = techStackRepository.findById(techStackId);
            if (isTechStackPresent.isPresent()){
                techStackModels.add(isTechStackPresent.get());
            }
        });
        CandidateModel candidateModel = new CandidateModel(candidateDTO);
        if (techStackModels.size() > 0)
            candidateModel.setTechStackModels(techStackModels);
        candidateModel.setCreationTimeStamp(LocalDateTime.now());
        candidateRepository.save(candidateModel);
       email.setTo(candidateModel.getEmail());
       email.setFrom("himanshi@gmail.com");
       email.setSubject("Message sent....");
       email.setBody("Message Sent to email");
       messageproducer.sendMessage(email);
//        String body = "Candidate added Successfully with id  :" + candidateModel.getId();
//        String subject = "Candidate added Successfully....";
//        mailService.send(candidateModel.getEmail(), body, subject);
        return candidateModel;
    }


    @Override
    public List<CandidateModel> getAllCandidateData(String token) {
        Long candidateId = tokenUtil.decodeToken(token);
        Optional<CandidateModel> isCandidatePresent = candidateRepository.findById(candidateId);
        if (isCandidatePresent.isPresent()){
            List<CandidateModel> getAllCandidate = candidateRepository.findAll();
            if (getAllCandidate.size() > 0)
                return getAllCandidate;
            else
                throw new AdminException(400, "No Data Found");
        }
        throw new AdminException(400, "Candidate not found");
    }

    @Override
    public CandidateModel updateCandidate(long id, CandidateDTO candidateDTO, String token) {
        Long candidateId = tokenUtil.decodeToken(token);
        Optional<CandidateModel> isCandidatePresent = candidateRepository.findById(candidateId);
        if (isCandidatePresent.isPresent()) {
            isCandidatePresent.get().setCicId(candidateDTO.getCicId());
            isCandidatePresent.get().setFullName(candidateDTO.getFullName());
            isCandidatePresent.get().setMobileNum(candidateDTO.getMobileNum());
            isCandidatePresent.get().setHiredData(candidateDTO.getHiredData());
            isCandidatePresent.get().setDegree(candidateDTO.getDegree());
            isCandidatePresent.get().setAggrPer(candidateDTO.getAggrPer());
            isCandidatePresent.get().setCity(candidateDTO.getCity());
            isCandidatePresent.get().setState(candidateDTO.getState());
            isCandidatePresent.get().setPreferredJobLocation(candidateDTO.getPreferredJobLocation());
            isCandidatePresent.get().setStatus(candidateDTO.getStatus());
            isCandidatePresent.get().setCreationTimeStamp(candidateDTO.getCreationTimeStamp());
            isCandidatePresent.get().setUpdatedTimeStamp(candidateDTO.getUpdatedTimeStamp());
            String body = "Candidate updated Successfully with id  :" + isCandidatePresent.get().getId();
            String subject = "Candidate updated Successfully....";
            mailService.send(isCandidatePresent.get().getEmail(), body, subject);
            return isCandidatePresent.get();
        }
        throw  new AdminException(400, "Admin not Present");
    }

    @Override
    public CandidateModel deleteCandidate(Long id, String token) {
        Long candidateId = tokenUtil.decodeToken(token);
        Optional<CandidateModel> isCandidatePresent = candidateRepository.findById(candidateId);
        if (isCandidatePresent.isPresent()){
            candidateRepository.delete(isCandidatePresent.get());
            return isCandidatePresent.get();
        }
        throw new AdminException(400, "Candidate Not found");
    }

    @Override
    public List<CandidateModel> getCandidateStatus(String token, String status) {
        Long candidateId = tokenUtil.decodeToken(token);
        List<CandidateModel> isStatusPresent = candidateRepository.findByStatus(status);
        if (isStatusPresent.size()>0){
            return isStatusPresent;
        }
        throw new AdminException(400, "Status not found");
    }

    @Override
    public CandidateModel changeCandidateStatus(long id, String status, String token) {
        Long candidateId = tokenUtil.decodeToken(token);
        Optional<CandidateModel> isIdPresent = candidateRepository.findById(candidateId);
        if (isIdPresent.isPresent()){
            isIdPresent.get().setStatus(status);
            candidateRepository.save(isIdPresent.get());
            return isIdPresent.get();
        }
        throw new AdminException(400, "Status Not Found");
    }

    @Override
    public List<CandidateModel> getStatusCount(String status) {
       List<CandidateModel> isStatusPresent = candidateRepository.findByStatus(status);
        if (isStatusPresent.size()>0){
            return isStatusPresent;
        }
        throw new AdminException(400, "No Status Available");
    }
}
