package com.bridgelabz.lmsproject.service;

import com.bridgelabz.lmsproject.DTO.MentorDTO;
import com.bridgelabz.lmsproject.model.MentorModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IMentorService {
    MentorModel addMentor(MentorDTO mentorDTO);

    MentorModel getMentorById(long id);

    List<MentorModel> getAllMentorData(String token);

    MentorModel updateMentor(long id, MentorDTO mentorDTO, String token);

    MentorModel deleteMentor(Long id, String token);

}
