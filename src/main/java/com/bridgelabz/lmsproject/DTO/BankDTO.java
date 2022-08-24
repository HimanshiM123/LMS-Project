package com.bridgelabz.lmsproject.DTO;

import com.bridgelabz.lmsproject.model.AdminModel;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDateTime;

@Data
public class BankDTO {
    @Min(value = 11)
    private String accountNo;
    @Pattern(regexp = "^[A-Z]{4}0[A-Z0-9]{6}$")
    private String IFSCCode;
    @Pattern(regexp = "^[A-z]{3,}$")
    private String branch;
    @Pattern(regexp = "^[6789][0-9]{9}$")
    private String linkedMobileNo;
    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$",message = "Invalid Account Holder Name...!")
    private String accountHolderName;
    @NotNull(message = "creatorUser Should Not be null")
    private AdminModel creatorUser;
    private AdminModel updatedUser;
    private LocalDateTime creatorDateTime;
    private LocalDateTime updatedDateTime;

}
