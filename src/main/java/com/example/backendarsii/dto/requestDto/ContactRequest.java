package com.example.backendarsii.dto.requestDto;

import com.example.backendarsii.utils.enumData.Platform;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.URL;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ContactRequest {

    @NotNull(message = "userId is required")
    private Long userId;
    @Enumerated(EnumType.STRING)
    private Platform platform;
    @URL(message = "this URL is not valid")
    private String url;

}
