package com.bridgelabz.lmsproject.controller;

import com.bridgelabz.lmsproject.DTO.BankDTO;
import com.bridgelabz.lmsproject.DTO.TechStackDTO;
import com.bridgelabz.lmsproject.model.BankModel;
import com.bridgelabz.lmsproject.model.TechStackModel;
import com.bridgelabz.lmsproject.service.ITechStackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/techStack")
public class TechStackController {
    @Autowired
    ITechStackService techStackService;

    @PostMapping(value = "/addTechStackDetails")
    public TechStackModel addTechStackDetails(@Valid @RequestBody TechStackDTO techStackDTO, @RequestHeader String token) {

        return techStackService.addTechStackDetails(techStackDTO, token);
    }

    @GetMapping("/getTechStack")
    public List<TechStackModel> getAllTechStackDetails(@RequestHeader String token){

        return techStackService.getAllTechStackDetails(token);
    }

    @PutMapping("updateTechStackDetails/{id}")
    public TechStackModel updateTechStackDetails(@Valid @RequestBody TechStackDTO techStackDTO, @PathVariable long id, @RequestHeader String token){
        return techStackService.updateTechStackDetails(id, techStackDTO, token);
    }

    @DeleteMapping("deleteBankDetails/{id}")
    public TechStackModel deleteTechStackDetails(@PathVariable Long id, @RequestHeader String token){

        return techStackService.deleteTechStackDetails(id, token);

    }
}
