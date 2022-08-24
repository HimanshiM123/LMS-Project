package com.bridgelabz.lmsproject.service;

import com.bridgelabz.lmsproject.DTO.BankDTO;
import com.bridgelabz.lmsproject.Repository.IAdminRepository;
import com.bridgelabz.lmsproject.Repository.IBankRepository;
import com.bridgelabz.lmsproject.exception.AdminException;
import com.bridgelabz.lmsproject.model.AdminModel;
import com.bridgelabz.lmsproject.model.BankModel;
import com.bridgelabz.lmsproject.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BankService implements IBankService{
    @Autowired
    IBankRepository bankRepository;
    @Autowired
    IAdminRepository adminRepository;
    @Autowired
    TokenUtil tokenUtil;
    @Autowired
    MailService mailService;
    @Override
    public BankModel addBankDetails(BankDTO bankDTO, String token) {
        Long bankId = tokenUtil.decodeToken(token);
        Optional<AdminModel> isBankDetailsPresent = adminRepository.findById(bankId);
        Optional<AdminModel> isAdminPresent = adminRepository.findById(bankId);
        if (isAdminPresent.isPresent()){
            BankModel bankModel = new BankModel(bankDTO);
            if (isBankDetailsPresent.isPresent()){
                bankModel.setCreatorUser(isBankDetailsPresent.get());
                return bankModel;
            }
            throw new AdminException(400, "Bank Details Added successfully");
        }
        throw new AdminException(400, "Fail To Find Details");
    }

    @Override
    public List<BankModel> getAllBankDetails(String token) {
        Long bankId = tokenUtil.decodeToken(token);
        Optional<BankModel> isAccountPresent = bankRepository.findById(bankId);
        if (isAccountPresent.isPresent()){
            List<BankModel> getAllBankDetails = bankRepository.findAll();
            if (getAllBankDetails.size() > 0)
                return getAllBankDetails;
            else
                throw new AdminException(400, "No Data Found");
        }
        throw new AdminException(400, "Account not found");
    }

    @Override
    public BankModel updateBankDetails(long id, BankDTO bankDTO, String token) {
        Long bankId = tokenUtil.decodeToken(token);
        Optional<AdminModel> isAdminPresent = adminRepository.findById(bankId);
        BankModel bankModel = new BankModel(bankDTO);
        if (isAdminPresent.isPresent()){
            bankModel.setUpdatedUser(isAdminPresent.get());
        }
        Optional<AdminModel> isAdminPresent1 = adminRepository.findById(bankId);
        if (isAdminPresent1.isPresent()) {
            Optional<BankModel> isAccountPresent = bankRepository.findById(bankId);
            if (isAccountPresent.isPresent()) {
                isAccountPresent.get().setAccountNo(bankDTO.getAccountNo());
                isAccountPresent.get().setIFSCCode(bankDTO.getIFSCCode());
                isAccountPresent.get().setBranch(bankDTO.getBranch());
                isAccountPresent.get().setLinkedMobileNo(bankDTO.getLinkedMobileNo());
                isAccountPresent.get().setCreatorUser(bankDTO.getCreatorUser());
                isAccountPresent.get().setUpdatedUser(bankDTO.getUpdatedUser());
                isAccountPresent.get().setUpdatedDateTime(bankDTO.getUpdatedDateTime());
                return isAccountPresent.get();
            }
        }

            throw new AdminException(400, "Account not Present");
    }

    @Override
    public BankModel deleteBankDetails(Long id, String token) {
        Long bankId = tokenUtil.decodeToken(token);
        Optional<BankModel> isAccountPresent = bankRepository.findById(bankId);
        if (isAccountPresent.isPresent()){
            bankRepository.delete(isAccountPresent.get());
            return isAccountPresent.get();
        }
        throw new AdminException(400, "Account Not found");
    }
}
