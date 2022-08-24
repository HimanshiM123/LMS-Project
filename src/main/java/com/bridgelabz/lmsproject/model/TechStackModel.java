package com.bridgelabz.lmsproject.model;

import com.bridgelabz.lmsproject.DTO.TechStackDTO;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "techStack")
@Data
public class TechStackModel {
    @Id
//    @GenericGenerator(name = "tech_stack", strategy = "increment")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "techstack_id")
    private int id;
    private LocalDateTime creatorStamp;
    private String creatorUser;
    private String imagePath;
    private boolean status;
    private String techName;

    public TechStackModel(TechStackDTO techStackDTO) {
        this.creatorStamp = techStackDTO.getCreatorStamp();
        this.creatorUser = techStackDTO.getCreatorUser();
        this.imagePath = techStackDTO.getImagePath();
        this.status = techStackDTO.isStatus();
        this.techName = techStackDTO.getTechName();
    }

    public TechStackModel() {

    }
}
