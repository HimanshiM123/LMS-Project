package com.bridgelabz.lmsproject.model;

import com.bridgelabz.lmsproject.DTO.BankDTO;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "BankDetails")
@Data
public class BankModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String accountNo;
    private String IFSCCode;
    private String branch;
    private String linkedMobileNo;
    private String accountHolderName;
    @OneToOne
    private AdminModel creatorUser;
    @OneToOne
    private AdminModel updatedUser;
    private LocalDateTime creatorDateTime;
    private LocalDateTime updatedDateTime;

    public BankModel(BankDTO bankDTO) {
        this.accountNo = bankDTO.getAccountNo();
        this.IFSCCode = bankDTO.getIFSCCode();
        this.branch = bankDTO.getBranch();
        this.linkedMobileNo = bankDTO.getLinkedMobileNo();
        this.accountHolderName = bankDTO.getAccountHolderName();
        this.creatorUser = bankDTO.getCreatorUser();
        this.updatedUser = bankDTO.getUpdatedUser();
        this.creatorDateTime = bankDTO.getCreatorDateTime();
        this.updatedDateTime = bankDTO.getUpdatedDateTime();
    }

    public BankModel() {

    }
}
