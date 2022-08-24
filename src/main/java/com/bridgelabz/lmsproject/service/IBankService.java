package com.bridgelabz.lmsproject.service;

import com.bridgelabz.lmsproject.DTO.BankDTO;
import com.bridgelabz.lmsproject.model.BankModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IBankService {

    BankModel addBankDetails(BankDTO bankDTO, String token);
    List<BankModel> getAllBankDetails(String token);

    BankModel updateBankDetails(long id, BankDTO bankDTO, String token);

    BankModel deleteBankDetails(Long id, String token);


}
