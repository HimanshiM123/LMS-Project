package com.bridgelabz.lmsproject.DTO;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDateTime;
@Data
@NoArgsConstructor
@ToString
public class AdminDTO {
    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$",message = "Invalid FirstName...!")
    private String firstName;
    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$",message = "Invalid LastName...!")
    private String lastName;
    @Pattern(regexp = "^[6789][0-9]{9}$")
    private String mobile;
    @NotNull(message = "emailId should not be null")
    private String emailId;
    @NotNull(message = "Profile path should not be null")
    private String profilePath;
    @NotNull(message = "Status Should be True or False")
    private boolean status;
    @NotNull(message = "Password should not be null")
    private String password;
    private LocalDateTime creatorStamp;
    private LocalDateTime updatedStamp;
}
