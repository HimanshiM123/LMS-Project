package com.bridgelabz.lmsproject.service;

import com.bridgelabz.lmsproject.DTO.AdminDTO;
import com.bridgelabz.lmsproject.model.AdminModel;
import com.bridgelabz.lmsproject.util.Response;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;

@Service
public interface IAdminService {
    String getMessage();

    AdminModel addAdmin(AdminDTO adminDTO);

    AdminModel getAdminById(long id);
    List<AdminModel> getAllAdminData(String token);

    AdminModel deleteAdmin(Long id, String token);

    AdminModel updateAdmin(long id, AdminDTO adminDTO, String token);


    Response login(String email, String password);

    AdminModel updatePassword(String token, String newPassword);

    AdminModel resetPassword(String email);
}
