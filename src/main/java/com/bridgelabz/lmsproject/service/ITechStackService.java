package com.bridgelabz.lmsproject.service;

import com.bridgelabz.lmsproject.DTO.TechStackDTO;
import com.bridgelabz.lmsproject.model.TechStackModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ITechStackService {
    TechStackModel addTechStackDetails(TechStackDTO techStackDTO, String token);

    List<TechStackModel> getAllTechStackDetails(String token);

    TechStackModel updateTechStackDetails(long id, TechStackDTO techStackDTO, String token);

    TechStackModel deleteTechStackDetails(Long id, String token);
}
