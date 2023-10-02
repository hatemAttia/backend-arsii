package com.example.backendarsii.service.serviceImpl;

import com.example.backendarsii.config.UtilsConfiguration;
import com.example.backendarsii.dto.requestDto.OpportunityRequest;
import com.example.backendarsii.dto.responseDto.OpportunityResponse;
import com.example.backendarsii.entity.Opportunity;
import com.example.backendarsii.entity.User;
import com.example.backendarsii.exception.NotFoundException;
import com.example.backendarsii.repository.OpportunityRepository;
import com.example.backendarsii.service.OpportunityService;
import com.example.backendarsii.utils.FileStorageService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class OpportunityServiceImpl implements OpportunityService {

    private final OpportunityRepository opportunityRepository;

    @Autowired
    private FileStorageService fileStorageService;
    @Override
    public void createOpportunity(OpportunityRequest request) {

        Opportunity opportunity = Opportunity.builder()
                .title(request.getTitle())
                .description(request.getDescription())
                .company(request.getCompany())
                .type(request.getType()).build();
        opportunityRepository.save(opportunity);

    }

    @Override
    public OpportunityResponse getOpportunityById(Long id) {
        Opportunity opportunity = opportunityRepository.findById(id).orElseThrow();
        return OpportunityResponse.makeOpportunity(opportunity);
    }

    @Override
    public List<OpportunityResponse> getAllOpportunity() {

        List<Opportunity> opportunities = opportunityRepository.findAll();
        List<OpportunityResponse> opportunityResponses = new ArrayList<>();
        for (Opportunity opportunity: opportunities) {
            OpportunityResponse opportunityResponse = OpportunityResponse.makeOpportunity(opportunity);
            opportunityResponses.add(opportunityResponse);
        }

        return opportunityResponses;
    }

    @Override
    public void updateOpportunity(OpportunityRequest request,Long id) {

        Opportunity opportunity = opportunityRepository.findById(id).orElseThrow();

        opportunity.setTitle(request.getTitle());
        opportunity.setDescription(request.getDescription());
        opportunity.setCompany(request.getCompany());
        opportunity.setType(request.getType());

        opportunityRepository.save(opportunity);


    }

    @Override
    public void deleteOpportunity(Long id) {

        if (opportunityRepository.existsById(id)){
            opportunityRepository.deleteById(id);
        }else {
            throw new NotFoundException("opportunity is not exist");
        }

    }


}
