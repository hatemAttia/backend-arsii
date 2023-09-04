package com.example.backendarsii.dto.responseDto;


import com.example.backendarsii.entity.Competence;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.Instant;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class CompetenceResponse {

    private Long id;
    private String name;
    private String description;
    private CategoryResponse category;
    private Instant createdAt;
    private Instant updatedAt;

    public static CompetenceResponse makeCompetence(Competence competence){
        return CompetenceResponse.builder()
                .id(competence.getId())
                .name(competence.getName())
                .description(competence.getDescription())
                .category(CategoryResponse.makeCategory(competence.getCategory()))
                .createdAt(competence.getCreatedAt())
                .updatedAt(competence.getUpdatedAt()).build();
    }

}
