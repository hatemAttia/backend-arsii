package com.example.backendarsii.service;

import com.example.backendarsii.dto.requestDto.OpportunityRequest;
import com.example.backendarsii.dto.responseDto.OpportunityResponse;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface OpportunityService {

    void createOpportunity(OpportunityRequest request);
    OpportunityResponse getOpportunityById (Long id);
    List<OpportunityResponse> getAllOpportunity();
    void updateOpportunity(OpportunityRequest request,Long id);
    void deleteOpportunity(Long id);




}
