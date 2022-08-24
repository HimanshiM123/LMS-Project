package com.bridgelabz.lmsproject.service;

import com.bridgelabz.lmsproject.DTO.MentorDTO;
import com.bridgelabz.lmsproject.Repository.IMentorRepository;
import com.bridgelabz.lmsproject.exception.AdminException;
import com.bridgelabz.lmsproject.model.MentorModel;
import com.bridgelabz.lmsproject.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class MentorService implements IMentorService{

    @Autowired
    IMentorRepository mentorRepository;
    @Autowired
    TokenUtil tokenUtil;
    @Autowired
    MailService mailService;
    @Override
    public MentorModel addMentor(MentorDTO mentorDTO) {
        MentorModel mentorModel = new MentorModel(mentorDTO);
        mentorModel.setCreatedTimeStamp(LocalDateTime.now());
        mentorRepository.save(mentorModel);
        String body = "Mentor added Successfully with id  :" + mentorModel.getId();
        String subject = "Mentor added Successfully....";
        mailService.send(mentorModel.getEmail(), body, subject);
        return mentorModel;
    }

    @Override
    public MentorModel getMentorById(long id) {
        Optional<MentorModel> mentorModel = mentorRepository.findById(id);
        return mentorModel.get();
    }

    @Override
    public List<MentorModel> getAllMentorData(String token) {
        Long mentorId = tokenUtil.decodeToken(token);
        Optional<MentorModel> isMentorPresent = mentorRepository.findById(mentorId);
        if (isMentorPresent.isPresent()){
            List<MentorModel> getAllMentor = mentorRepository.findAll();
            if (getAllMentor.size() > 0)
                return getAllMentor;
            else
                throw new AdminException(400, "No Data Found");
        }
        throw new AdminException(400, "Mentor not found");
    }

    @Override
    public MentorModel updateMentor(long id, MentorDTO mentorDTO, String token) {
        Long mentorId = tokenUtil.decodeToken(token);
        Optional<MentorModel> isMentorPresent = mentorRepository.findById(mentorId);
        if (isMentorPresent.isPresent()){
            isMentorPresent.get().setEmployeeId(mentorDTO.getEmployeeId());
            isMentorPresent.get().setFirstName(mentorDTO.getFirstName());
            isMentorPresent.get().setLastName(mentorDTO.getLastName());
            isMentorPresent.get().setMentorType(mentorDTO.getMentorType());
            isMentorPresent.get().setMobileNum(mentorDTO.getMobileNum());
            isMentorPresent.get().setEmail(mentorDTO.getEmail());
            isMentorPresent.get().setExperienceYear(mentorDTO.getExperienceYear());
            isMentorPresent.get().setPreferredTime(mentorDTO.getPreferredTime());
            isMentorPresent.get().setStartDate(mentorDTO.getStartDate());
            isMentorPresent.get().setStatus(mentorDTO.getStatus());
            isMentorPresent.get().setMentorDescription(mentorDTO.getMentorDescription());
            isMentorPresent.get().setProfileImageUrl(mentorDTO.getProfileImageUrl());
            isMentorPresent.get().setCreatorUser(mentorDTO.getCreatorUser());
            isMentorPresent.get().setSupervisor(mentorDTO.getSupervisor());
            isMentorPresent.get().setCreatedTimeStamp(mentorDTO.getCreatedTimeStamp());
            isMentorPresent.get().setUpdatedTimeStamp(mentorDTO.getUpdatedTimeStamp());
            String body = "Mentor updated Successfully with id  :" + isMentorPresent.get().getId();
            String subject = "Mentor updated Successfully....";
            mailService.send(isMentorPresent.get().getEmail(), body, subject);
            return isMentorPresent.get();
        }
        throw  new AdminException(400, "Mentor not Present");
    }

    @Override
    public MentorModel deleteMentor(Long id, String token) {
        Long mentorId = tokenUtil.decodeToken(token);
        Optional<MentorModel> isMentorPresent = mentorRepository.findById(mentorId);
        if (isMentorPresent.isPresent()){
            mentorRepository.delete(isMentorPresent.get());
            return isMentorPresent.get();
        }
        throw new AdminException(400, "Mentor Not found");
    }
}
