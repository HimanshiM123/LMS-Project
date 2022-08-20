package com.bridgelabz.lmsproject.controller;

import com.bridgelabz.lmsproject.DTO.CandidateDTO;
import com.bridgelabz.lmsproject.model.CandidateModel;
import com.bridgelabz.lmsproject.service.ICandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

public class CandidateController {
    @Autowired
    ICandidateService candidateService;

    @PostMapping(value = "/addCandidate")
    public CandidateModel addAdminData(@Valid @RequestBody CandidateDTO candidateDTO) {
        return candidateService.addCandidate(candidateDTO);
    }

    @GetMapping("/getCandidate/{id}")
    public CandidateModel getCandidate(@PathVariable long id){
        return candidateService.getCandidateById(id);
    }

    @GetMapping("/getCandidate")
    public List<CandidateModel> getAllCandidate(@RequestHeader String token){
        return candidateService.getAllCandidateData(token);
    }

    @PutMapping("updateCandidate/{id}")
    public CandidateModel updateCandidate(@Valid @RequestBody CandidateDTO candidateDTO, @PathVariable long id, @RequestHeader String token ){
        return candidateService.updateCandidate(id, candidateDTO, token);
    }

    @DeleteMapping("deleteCandidate/{id}")
    public CandidateModel deleteCandidate(@PathVariable Long id, @RequestHeader String token){
        return candidateService.deleteCandidate(id, token);
    }

    @GetMapping("/getCandidate/{status}")
    public List<CandidateModel> getCandidateStatus(@RequestHeader String token, @PathVariable String status){
        return candidateService.getCandidateStatus(token, status);
    }

    @PutMapping("/changeCandidateStatus")
    public CandidateModel changeCandidateStatus(@PathVariable long id, @RequestParam String status, @RequestHeader String token){
        return candidateService.changeCandidateStatus(id, status, token);
    }
    @GetMapping("/count/{status}")
    public List<CandidateModel> statusCount(@RequestParam String status){
        return candidateService.getStatusCount(status);
    }

}
