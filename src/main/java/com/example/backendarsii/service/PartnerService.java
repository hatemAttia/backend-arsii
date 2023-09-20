package com.example.backendarsii.service;

import com.example.backendarsii.dto.requestDto.PartnerRequest;
import com.example.backendarsii.dto.responseDto.PartnerResponse;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface PartnerService {

    void addPartner(PartnerRequest partnerRequest);

    List<PartnerResponse> getAllPartner();

    PartnerResponse getPartnerByID(Long id);

    void updatePartner(Long id, PartnerRequest partnerRequest);

    void deletePartner(Long id);
    void uploadImage(MultipartFile file, Long id);
    Resource serveImage(String fileName);

}
