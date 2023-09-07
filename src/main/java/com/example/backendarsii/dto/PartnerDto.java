package com.example.backendarsii.dto;

import com.example.backendarsii.entity.Partner;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PartnerDto {
    private Integer id;
    private String name;
    private String address;
    private String type;
    private String contact;
    private String description;
    private Instant createdAt;
    private Instant updatedAt;
    public static PartnerDto makePartner(Partner partner){
        return PartnerDto.builder()
                .id(partner.getId())
                .name(partner.getName())
                .address(partner.getAddress())
                .type(partner.getType())
                .contact(partner.getContact())
                .description(partner.getDescription())
                .createdAt(partner.getCreatedAt())
                .updatedAt(partner.getUpdatedAt())
                .build();
}}
