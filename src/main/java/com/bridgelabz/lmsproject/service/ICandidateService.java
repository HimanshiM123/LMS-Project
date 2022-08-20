package com.bridgelabz.lmsproject.service;

import com.bridgelabz.lmsproject.DTO.CandidateDTO;
import com.bridgelabz.lmsproject.model.CandidateModel;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ICandidateService {
    CandidateModel addCandidate(CandidateDTO candidateDTO);

    CandidateModel getCandidateById(long id);

    List<CandidateModel> getAllCandidateData(String token);

    CandidateModel updateCandidate(long id, CandidateDTO candidateDTO, String token);

    CandidateModel deleteCandidate(Long id, String token);

    List<CandidateModel> getCandidateStatus(String token, String status);

    CandidateModel changeCandidateStatus(long id, String status, String token);

    List<CandidateModel> getStatusCount(String status);
}
