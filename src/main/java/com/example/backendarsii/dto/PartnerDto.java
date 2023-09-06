package com.example.backendarsii.dto;

import com.example.backendarsii.entity.Partner;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PartnerDto {
    private Long id;
    private String name;
    private String adress;
    private String type;
    private String contact;
    private String description;
    private Date createdAt;
    private Date updatedAt;
    private boolean deleted = Boolean.FALSE;

    public static PartnerDto makePartner(Partner partner){
        return PartnerDto.builder()
                .id(partner.getId())
                .name(partner.getName())
                .adress(partner.getAdress())
                .type(partner.getType())
                .contact(partner.getContact())
                .description(partner.getDescription())
                .createdAt(partner.getCreatedAt())
                .updatedAt(partner.getUpdatedAt())
                .deleted(partner.isDeleted())
                .build();
}}
