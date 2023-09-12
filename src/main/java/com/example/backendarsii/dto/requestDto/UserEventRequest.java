package com.example.backendarsii.dto.requestDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserEventRequest {
    @NotNull(message = "Event id is required")
    private Long eventId;
    @NotNull(message = "user id is required")
    private Long userId;
}
