package com.example.backendarsii.dto.responseDto;

import com.example.backendarsii.entity.User;
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
import java.time.Instant;
import java.util.Date;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {

    private Long id;
    private String firstName;
    private String lastName;
    private String userName;
    private String email;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private Date dateOfBirth;
    private String phoneNumber;
    private String region;
    private String job;
    private String universityOrCompany;
    @Enumerated(EnumType.STRING)
    private Post post;
    @Enumerated(EnumType.STRING)
    private Office office;
    private String image;
    private String cv;
    private List<ContactResponse> contacts;
    private boolean status;
    private boolean isPaid;

    private Instant createdAt;
    private Instant updatedAt;
    private Instant expiresAt;
    @Enumerated(EnumType.STRING)
    private Role role;

    public static UserResponse makeUser(User user) {
        return UserResponse.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .userName(user.getUsername())
                .email(user.getEmail())
                .gender(user.getGender())
                .job(user.getJob())
                .universityOrCompany(user.getUniversityOrCompany())
                .phoneNumber(user.getPhoneNumber())
                .region(user.getRegion())
                .dateOfBirth(user.getDateOfBirth())
                .post(user.getPost())
                .office(user.getOffice())
                .image(user.getImage())
                .cv(user.getCv())
                .contacts(ContactResponse.makeContacts(user.getContacts()))
                .status(user.isStatus())
                .isPaid(user.isPaid())
                .createdAt(user.getCreatedAt())
                .updatedAt(user.getUpdatedAt())
                .expiresAt(user.getExpiresAt())
                .role(user.getRole())
                .build();
    }

}
