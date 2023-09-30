package com.example.backendarsii.dto.searchRequest;

import com.example.backendarsii.utils.enumData.Gender;
import com.example.backendarsii.utils.enumData.Office;
import com.example.backendarsii.utils.enumData.Post;
import com.example.backendarsii.utils.enumData.Role;
import lombok.*;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SearchAdmin {
    private Long id;
    private String firstName;
    private String lastName;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private String region;
    private String job;
    private String universityOrCompany;
    @Enumerated(EnumType.STRING)
    private Post post;
    @Enumerated(EnumType.STRING)
    private Office office;
    private boolean status = Boolean.FALSE;
    private boolean isPaid ;
    @Enumerated(EnumType.STRING)
    private Role role;

}
