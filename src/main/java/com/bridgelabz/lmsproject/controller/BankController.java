package com.bridgelabz.lmsproject.controller;

import com.bridgelabz.lmsproject.DTO.BankDTO;
import com.bridgelabz.lmsproject.model.BankModel;
import com.bridgelabz.lmsproject.service.IBankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/BankDetails")
public class BankController {
    @Autowired
    IBankService bankService;

    @PostMapping(value = "/addBankDetails")
    public BankModel addBankDetails(@Valid @RequestBody BankDTO bankDTO, @RequestHeader String token) {

        return bankService.addBankDetails(bankDTO, token);
    }

    @GetMapping("/getBank")
    public List<BankModel> getAllBankDetails(@RequestHeader String token){

        return bankService.getAllBankDetails(token);
    }

    @PutMapping("updateBankDetails/{id}")
    public BankModel updateBankDetails(@Valid @RequestBody BankDTO bankDTO, @PathVariable long id, @RequestHeader String token){
        return bankService.updateBankDetails(id, bankDTO, token);
    }

    @DeleteMapping("deleteBankDetails/{id}")
    public BankModel deleteBankDetails(@PathVariable Long id, @RequestHeader String token){

        return bankService.deleteBankDetails(id, token);

    }
}
