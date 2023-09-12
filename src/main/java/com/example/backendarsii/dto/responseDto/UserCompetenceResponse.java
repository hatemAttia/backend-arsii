package com.example.backendarsii.dto.responseDto;

import com.example.backendarsii.entity.Competence;

import com.example.backendarsii.entity.UserCompetence;
import com.example.backendarsii.utils.enumData.Level;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.Instant;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserCompetenceResponse {


    private Long id;
    @Enumerated(EnumType.STRING)
    private Level level;
    private CompetenceResponse competence;
    private Instant createdAt;
    private Instant updatedAt;



    public static UserCompetenceResponse makeUserCompetence(UserCompetence userCompetence){
        return UserCompetenceResponse.builder()
                .id(userCompetence.getId())
                .level(userCompetence.getLevel())
                .createdAt(userCompetence.getCreatedAt())
                .updatedAt(userCompetence.getUpdatedAt())
                .competence(CompetenceResponse.makeCompetence(userCompetence.getCompetence()))
                .build();

    }

}
