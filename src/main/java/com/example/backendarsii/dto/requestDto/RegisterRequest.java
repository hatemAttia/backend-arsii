package com.example.backendarsii.dto.requestDto;

import com.example.backendarsii.utils.enumData.Gender;
import com.example.backendarsii.utils.enumData.Office;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.URL;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {




    @NotBlank(message = "First name is required")
    private String firstName;
    @NotBlank(message = "Last name is required")
    private String lastName;
    @NotBlank(message = "Username is required")
    private String userName;
    @Email(message ="your email is not valid" )
    private String email;
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&.])[A-Za-z\\d@$!%*#?&.]{8,}$",
            message = "The password must contain at least 8 characters, including an uppercase letter, a lowercase letter, a number, and a special symbol.")
    private String password;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Pattern(regexp = "^[0-9]{8}$",message = "phone number not valid")
    private String phoneNumber;
    @NotBlank(message = "your region is required")
    private String region;
    private String job;
    private String universityOrCompany;
    @Enumerated(EnumType.STRING)
    private Office office;
    @URL(message = "this UrlImage is not valid")
    private String image;




}
