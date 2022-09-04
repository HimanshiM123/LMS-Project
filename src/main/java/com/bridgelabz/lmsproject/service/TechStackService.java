package com.bridgelabz.lmsproject.service;

import com.bridgelabz.lmsproject.DTO.TechStackDTO;
import com.bridgelabz.lmsproject.Repository.ITechStackRepository;
import com.bridgelabz.lmsproject.exception.AdminException;
import com.bridgelabz.lmsproject.model.AdminModel;
import com.bridgelabz.lmsproject.model.MentorModel;
import com.bridgelabz.lmsproject.model.TechStackModel;
import com.bridgelabz.lmsproject.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TechStackService implements ITechStackService{

    @Autowired
    ITechStackRepository iTechStackRepository;
    @Autowired
    TokenUtil tokenUtil;
    @Autowired
    MailService mailService;
    @Override
    public TechStackModel addTechStackDetails(TechStackDTO techStackDTO, String token) {

        TechStackModel techStackModel = new TechStackModel(techStackDTO);
        techStackModel.setCreatorStamp(LocalDateTime.now());
        iTechStackRepository.save(techStackModel);
        return techStackModel;
    }

    @Override
    public List<TechStackModel> getAllTechStackDetails(String token) {

        Long adminId = tokenUtil.decodeToken(token);
        Optional<TechStackModel> isAdminPresent = iTechStackRepository.findById(adminId);
        if (isAdminPresent.isPresent()){
            List<TechStackModel> getListOfAdmin = iTechStackRepository.findAll();
            if (getListOfAdmin.size() > 0)
                return getListOfAdmin;
            else
                throw new AdminException(400, "No Data Found");
        }
        throw new AdminException(400, "Admin not found");
    }

    @Override
    public TechStackModel updateTechStackDetails(long id, TechStackDTO techStackDTO, String token) {
        Long adminId = tokenUtil.decodeToken(token);
        Optional<TechStackModel> isAdminPresent = iTechStackRepository.findById(adminId);
        if (isAdminPresent.isPresent()){
            isAdminPresent.get().setCreatorStamp(techStackDTO.getCreatorStamp());
            isAdminPresent.get().setCreatorUser(techStackDTO.getCreatorUser());
            isAdminPresent.get().setImagePath(techStackDTO.getImagePath());
            isAdminPresent.get().setStatus(techStackDTO.isStatus());
            isAdminPresent.get().setTechName(techStackDTO.getTechName());
            return isAdminPresent.get();
        }
        throw  new AdminException(400, "Admin not Present");

    }

    @Override
    public TechStackModel deleteTechStackDetails(Long id, String token) {

        Long adminId = tokenUtil.decodeToken(token);
        Optional<TechStackModel> isAdminPresent = iTechStackRepository.findById(adminId);
        if (isAdminPresent.isPresent()){
            iTechStackRepository.delete(isAdminPresent.get());
            return isAdminPresent.get();
        }
        throw new AdminException(400, "Admin Not found");
    }
}
