package com.example.backendarsii.dto.requestDto;

import com.example.backendarsii.utils.enumData.EventType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateEventRequest {

    @NotBlank(message = "title is required")
    private String title;
    @NotBlank(message = "description is required")
    private String description;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime date;

    private Long maxOfParticipants;
    private String formateur;
    private Long price;

    @NotBlank(message = "location is required")
    private String location;
    private String urlFacebook;
    private String image;
    @Enumerated(EnumType.STRING)
    private EventType type;
    private Long partnerId;
    private boolean status;
    private boolean isActivity;


}
