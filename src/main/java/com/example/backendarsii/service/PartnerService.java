package com.example.backendarsii.service;

import com.example.backendarsii.dto.PartnerDto;
import com.example.backendarsii.dto.PartnerRequest;

import java.util.List;

public interface PartnerService {
    void createPartner(PartnerRequest partnerRequest);
    List<PartnerDto> getAllPartners();

    PartnerDto getPartnerById(Integer id);

    PartnerDto updatePartner(Integer id, PartnerRequest partnerRequest);

    void deletePartner(Integer id);

}
