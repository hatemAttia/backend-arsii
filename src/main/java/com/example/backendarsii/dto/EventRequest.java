package com.example.backendarsii.dto;

import com.example.backendarsii.dto.enumData.TypeEvent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventRequest {
    private String title;
    private String description;
    private String former;
    private String URLImage;
    private int numberOfParticipants;
    private String location;
    private boolean status;
    @Enumerated(EnumType.STRING)
    private TypeEvent typeEvent;
}
