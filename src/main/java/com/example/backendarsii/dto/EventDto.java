package com.example.backendarsii.dto;


import com.example.backendarsii.dto.enumData.TypeEvent;
import com.example.backendarsii.entity.Event;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EventDto {
    private Long id;
    private String title;
    private String description;
    private Date date;
    private String former;
    private String URLImage;
    private int numberOfParticipants;
    private String location;
    private boolean status;
    @Enumerated(EnumType.STRING)
    private TypeEvent typeEvent;
    private boolean isActive;
    private Date createdAt;
    private Date updatedAt;
    private boolean deleted = Boolean.FALSE;

    public static EventDto makeEvent(Event event){
        return EventDto.builder()
                .id(event.getId())
                .title(event.getTitle())
                .description(event.getDescription())
                .date(event.getDate())
                .former(event.getFormer())
                .URLImage(event.getURLImage())
                .numberOfParticipants(event.getNumberOfParticipants())
                .location(event.getLocation())
                .status(event.isStatus())
                .typeEvent(event.getTypeEvent())
                .isActive(event.isActive())
                .createdAt(event.getCreatedAt())
                .updatedAt(event.getUpdatedAt())
                .deleted(event.isDeleted())
                .build();
}



}
