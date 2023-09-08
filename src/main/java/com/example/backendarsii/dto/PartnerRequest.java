package com.example.backendarsii.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class PartnerRequest {
    @NotBlank(message = "bl")
    private String name;
    @NotBlank(message = "bl")
    private String address;
    @NotBlank(message = "bl")
    private String type;
    @NotBlank(message = "bl")
    private String contact;
    @NotBlank(message = "bl")
    private String description;
}
