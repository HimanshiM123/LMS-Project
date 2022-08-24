package com.bridgelabz.lmsproject.service;

import com.bridgelabz.lmsproject.DTO.TechStackDTO;
import com.bridgelabz.lmsproject.model.TechStackModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TechStackService implements ITechStackService{
    @Override
    public TechStackModel addTechStackDetails(TechStackDTO techStackDTO, String token) {
        return null;
    }

    @Override
    public List<TechStackModel> getAllTechStackDetails(String token) {
        return null;
    }

    @Override
    public TechStackModel updateTechStackDetails(long id, TechStackDTO techStackDTO, String token) {
        return null;
    }

    @Override
    public TechStackModel deleteTechStackDetails(Long id, String token) {
        return null;
    }
}
