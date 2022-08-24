package com.bridgelabz.lmsproject.model;

import com.bridgelabz.lmsproject.DTO.CandidateDTO;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "Candidate")
@Data
public class CandidateModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String cicId;
    private String fullName;
    private String email;
    private String mobileNum;
    private String hiredData;
    private String degree;
    private Double aggrPer;
    private String city;
    private String state;
    private String preferredJobLocation;
    private String status;
    private String passOutYear;
    @OneToMany
//    @ElementCollection(fetch = FetchType.LAZY, targetClass = String.class)
    @CollectionTable(name = "techStackCandidate", joinColumns = @JoinColumn(name = "techStackId"))
    List<TechStackModel> techStackModels;
    private String candidateStatus;

    private LocalDateTime creationTimeStamp;
    private LocalDateTime updatedTimeStamp;

    public CandidateModel(CandidateDTO candidateDTO) {
        this.cicId = candidateDTO.getCicId();
        this.fullName = candidateDTO.getFullName();
        this.email = candidateDTO.getEmail();
        this.mobileNum = candidateDTO.getMobileNum();
        this.hiredData = candidateDTO.getHiredData();
        this.degree = candidateDTO.getDegree();
        this.aggrPer = candidateDTO.getAggrPer();
        this.city = candidateDTO.getCity();
        this.state = candidateDTO.getState();
        this.preferredJobLocation = candidateDTO.getPreferredJobLocation();
        this.status = candidateDTO.getStatus();
        this.passOutYear = candidateDTO.getPassOutYear();
        this.candidateStatus = candidateDTO.getCandidateStatus();
        this.creationTimeStamp = candidateDTO.getCreationTimeStamp();
        this.updatedTimeStamp = candidateDTO.getUpdatedTimeStamp();
    }

    public CandidateModel() {

    }
}
