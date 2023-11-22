package com.example.backendarsii.service;

import com.example.backendarsii.dto.requestDto.UserCompetenceRequest;
import com.example.backendarsii.dto.responseDto.UserCompetenceResponse;
import com.example.backendarsii.dto.responseDto.UserResponse;

import java.util.List;
import java.util.UUID;

public interface UserCompetenceService {

    void addUserCompetence(UserCompetenceRequest userCompetenceRequest);

    void updateUserCompetence(Long id, UserCompetenceRequest userCompetenceRequest);

    List<UserCompetenceResponse> getAllCompetenceByUser(UUID id);

    List<UserResponse> getAllUserByCompetence(Long id);

    void deleteUserCompetence(Long id);

}
