package com.example.backendarsii.service;


import com.example.backendarsii.dto.requestDto.UserFormationRequest;
import com.example.backendarsii.dto.responseDto.FormationUserResponse;
import com.example.backendarsii.dto.responseDto.UserFormationResponse;

import java.util.List;

public interface UserFormationService {

    void joinFormation(UserFormationRequest request);

    List<FormationUserResponse> getListOfFormationByUser(Long userId);

    List<UserFormationResponse> getListOfUserByFormation(Long formationId);

    void deleteUserFormation(Long id);


}
