package com.bridgelabz.lmsproject.service;

import com.bridgelabz.lmsproject.DTO.HiringCandidateDTO;
import com.bridgelabz.lmsproject.model.HiringCandidateModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IHiringCandidateService {
    HiringCandidateModel addHiredCandidate(HiringCandidateDTO hiringCandidateDTO, String token);

    List<HiringCandidateModel> getAllHiredCandidateDetails(String token);

    HiringCandidateModel updateHiredCandidateDetails(long id, HiringCandidateDTO hiringCandidateDTO, String token);

    HiringCandidateModel deleteHiredCandidateDetails(Long id, String token);
}
