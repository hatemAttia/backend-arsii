package com.example.backendarsii.dto.requestDto;

import com.example.backendarsii.utils.enumData.OpportunityType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class OpportunityRequest {


    @NotBlank(message = "title is required")
    private String title;
    private String description;
    @Enumerated(EnumType.STRING)
    private OpportunityType type;
    private String company;

}
