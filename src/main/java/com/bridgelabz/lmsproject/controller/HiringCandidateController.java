package com.bridgelabz.lmsproject.controller;

import com.bridgelabz.lmsproject.DTO.BankDTO;
import com.bridgelabz.lmsproject.DTO.HiringCandidateDTO;
import com.bridgelabz.lmsproject.model.BankModel;
import com.bridgelabz.lmsproject.model.HiringCandidateModel;
import com.bridgelabz.lmsproject.service.IHiringCandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/hiringCandidate")
public class HiringCandidateController {
    @Autowired
    IHiringCandidateService hiringCandidateService;

    @PostMapping(value = "/addHiredCandidate")
    public HiringCandidateModel addHiredCandidate(@Valid @RequestBody HiringCandidateDTO hiringCandidateDTO, @RequestHeader String token) {

        return hiringCandidateService.addHiredCandidate(hiringCandidateDTO, token);
    }

    @GetMapping("/getHiredCandidate")
    public List<HiringCandidateModel> getAllHiredCandidateDetails(@RequestHeader String token){

        return hiringCandidateService.getAllHiredCandidateDetails(token);
    }

    @PutMapping("updateHiredCandidateDetails/{id}")
    public HiringCandidateModel updateHiredCandidateDetails(@Valid @RequestBody HiringCandidateDTO hiringCandidateDTO, @PathVariable long id, @RequestHeader String token){
        return hiringCandidateService.updateHiredCandidateDetails(id, hiringCandidateDTO, token);
    }

    @DeleteMapping("deleteHiredCandidateDetails/{id}")
    public HiringCandidateModel deleteHiredCandidateDetails(@PathVariable Long id, @RequestHeader String token){

        return hiringCandidateService.deleteHiredCandidateDetails(id, token);

    }
}
