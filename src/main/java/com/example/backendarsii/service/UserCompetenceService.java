package com.example.backendarsii.service;

import com.example.backendarsii.dto.requestDto.UserCompetenceRequest;
import com.example.backendarsii.dto.responseDto.UserCompetenceResponse;
import com.example.backendarsii.dto.responseDto.UserResponse;

import java.util.List;

public interface UserCompetenceService {

    void addUserCompetence(UserCompetenceRequest userCompetenceRequest);

    void updateUserCompetence(Long id, UserCompetenceRequest userCompetenceRequest);

    List<UserCompetenceResponse> getAllCompetenceByUser(Long id);

    List<UserResponse> getAllUserByCompetence(Long id);

    void deleteUserCompetence(Long id);

}
