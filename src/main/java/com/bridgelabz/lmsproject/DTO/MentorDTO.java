package com.bridgelabz.lmsproject.DTO;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.time.LocalDateTime;
@Data
@NoArgsConstructor
@ToString
public class MentorDTO {
    private String employeeId;
    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$",message = "Invalid FirstName...!")
    private String firstName;
    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$",message = "Invalid LastName...!")
    private String lastName;
    private String mentorType;
    private String mentorRole;
    @Pattern(regexp = "^[6789][0-9]{9}$")
    private String mobileNum;
    private String email;
    private String experienceYear;
    private String preferredTime;
    private LocalDate startDate;
    private String status;
    private String mentorDescription;
    private String profileImageUrl;
    private int creatorUser;
    private long supervisor;
    private LocalDateTime createdTimeStamp;
    private LocalDateTime updatedTimeStamp;

}
