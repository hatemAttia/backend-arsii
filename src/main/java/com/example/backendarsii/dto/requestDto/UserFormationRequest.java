package com.example.backendarsii.dto.requestDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserFormationRequest {
    @NotNull(message = "Formation id is required")
    private Long formationId;
    @NotNull(message = "user id is required")
    private Long userId;
}
