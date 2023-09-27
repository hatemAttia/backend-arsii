package com.example.backendarsii.dto.requestDto;

import com.example.backendarsii.utils.enumData.PartnerType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.URL;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PartnerRequest {


    @NotBlank(message = "Name is required")
    private String name;
    @NotBlank(message = "description is required")
    private String description;
    @NotBlank(message = "address is required")
    private String address;
    @NotBlank(message = "Contact is required")
    private String contact;
    @Enumerated(EnumType.STRING)
    private PartnerType type;
    private String image;


}
