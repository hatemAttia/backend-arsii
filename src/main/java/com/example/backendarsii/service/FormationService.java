package com.example.backendarsii.service;

import com.example.backendarsii.dto.requestDto.FormationRequest;
import com.example.backendarsii.dto.requestDto.UpdateFormationRequest;
import com.example.backendarsii.dto.responseDto.FormationResponse;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface FormationService {

    void addFormation(FormationRequest formationRequest, boolean status);

    List<FormationResponse> getAllFormation();

    List<FormationResponse> getAllSuggestFormation();

    FormationResponse getFormationById(Long id);

    void updateFormation(Long id, UpdateFormationRequest updateFormation);

    void deleteFormation(Long id);
    void uploadImage(MultipartFile file, Long id);
    Resource serveImage(String fileName);

}
