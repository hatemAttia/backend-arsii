package com.example.backendarsii.dto.responseDto;


import com.example.backendarsii.entity.Club;
import com.example.backendarsii.utils.enumData.Post;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.Instant;
import java.util.Date;

@Data
@Builder
//@AllArgsConstructor
//@NoArgsConstructor
public class ClubResponse {

    private Integer id;
    private String name;
    private String logo;
    private String location;
    private String description;
    private String contact;
    @Enumerated(EnumType.STRING)
    private boolean status;
    private Instant createdAt;
    private Instant updatedAt;

    public static ClubResponse makeClub(Club club)
    {
        return  ClubResponse.builder()
                .id(club.getId())
                .name(club.getName())
                .logo(club.getLogo())
                .location(club.getLocation())
                .description(club.getDescription())
                .contact(club.getContact())
                .status(club.isStatus())
                .createdAt(club.getCreatedAt())
                .updatedAt(club.getUpdatedAt())
                .build();
    }

}
