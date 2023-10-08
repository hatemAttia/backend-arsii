package com.example.backendarsii.dto.requestDto;

import com.example.backendarsii.utils.enumData.Gender;
import com.example.backendarsii.utils.enumData.Office;
import com.example.backendarsii.utils.enumData.Post;
import com.example.backendarsii.utils.enumData.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpdateUserRequest {


    private String firstName;
    private String lastName;
    private String userName;
    @Email(message = "your email is not valid")
    private String email;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private Date dateOfBirth;
    @Pattern(regexp = "^[0-9]{8}$", message = "phone number not valid")
    private String phoneNumber;
    private String region;
    private String job;
    private String universityOrCompany;
    @Enumerated(EnumType.STRING)
    private Office office;
    private String image;
    private String cv;
    @Enumerated(EnumType.STRING)
    private Post post;
    @Enumerated(EnumType.STRING)
    private Role role;

}
