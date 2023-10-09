package com.example.backendarsii.dto.responseDto;

import com.example.backendarsii.entity.Event;
import com.example.backendarsii.utils.enumData.EventType;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.time.LocalDateTime;

@Data
@Builder
public class EventResponse {

    private Long id;
    private String title;
    private String description;
    private LocalDateTime date;
    private String image;
    private Long maxOfParticipants;
    private Long numberOfParticipants;
    private String formateur;
    private String location;
    private Long price;
    private EventType type;
    private PartnerResponse partner;
    private boolean status;
    private boolean isActivity;
    private Instant createdAt;
    private Instant updatedAt;

    public static EventResponse makeEvent(Event event) {
        if (event.getPartner() == null) {
            return EventResponse.builder()
                    .id(event.getId())
                    .title(event.getTitle())
                    .description(event.getDescription())
                    .date(event.getDate())
                    .image(event.getImage())
                    .numberOfParticipants(event.getNumberOfParticipants())
                    .location(event.getLocation())
                    .type(event.getType())
                    .status(event.isStatus())
                    .price(event.getPrice())
                    .maxOfParticipants(event.getMaxOfParticipants())
                    .isActivity(event.isActivity())
                    .createdAt(event.getCreatedAt())
                    .updatedAt(event.getUpdatedAt())
                    .build();
        }
        return EventResponse.builder()
                .id(event.getId())
                .title(event.getTitle())
                .description(event.getDescription())
                .date(event.getDate())
                .image(event.getImage())
                .numberOfParticipants(event.getNumberOfParticipants())
                .location(event.getLocation())
                .type(event.getType())
                .price(event.getPrice())
                .maxOfParticipants(event.getMaxOfParticipants())
                .partner(PartnerResponse.makePartner(event.getPartner()))
                .status(event.isStatus())
                .isActivity(event.isActivity())
                .createdAt(event.getCreatedAt())
                .updatedAt(event.getUpdatedAt())
                .build();
    }

}
