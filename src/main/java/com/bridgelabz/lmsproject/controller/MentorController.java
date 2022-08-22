package com.bridgelabz.lmsproject.controller;

import com.bridgelabz.lmsproject.DTO.AdminDTO;
import com.bridgelabz.lmsproject.DTO.MentorDTO;
import com.bridgelabz.lmsproject.model.AdminModel;
import com.bridgelabz.lmsproject.model.MentorModel;
import com.bridgelabz.lmsproject.service.IMentorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/mentor")
public class MentorController {

    @Autowired
    IMentorService mentorService;

    @PostMapping(value = "/addMentor")
    public MentorModel addMentorData(@Valid @RequestBody MentorDTO mentorDTO) {

        return mentorService.addMentor(mentorDTO);
    }
    @GetMapping("/getMentor/{id}")
    public MentorModel getMentor(@PathVariable long id){

        return mentorService.getMentorById(id);
    }
    @GetMapping("/getMentor")
    public List<MentorModel> getAllMentor(@RequestHeader String token){

        return mentorService.getAllMentorData(token);
    }
    @PutMapping("updateMentor/{id}")
    public MentorModel updateMentor(@Valid @RequestBody MentorDTO mentorDTO, @PathVariable long id, @RequestHeader String token ){
        return mentorService.updateMentor(id, mentorDTO, token);
    }
    @DeleteMapping("deleteMentor/{id}")
    public MentorModel deleteMentor(@PathVariable Long id, @RequestHeader String token){

        return mentorService.deleteMentor(id, token);

    }
}
