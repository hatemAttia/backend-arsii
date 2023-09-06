package com.example.backendarsii.service;

import com.example.backendarsii.dto.PartnerDto;
import java.util.List;

public interface PartnerService {
    List<PartnerDto> getAllPartners();

    PartnerDto getPartnerById(Long id);

    PartnerDto updatePartner(Long id, PartnerDto partnerDto);

    void deletePartner(Long id);
}
