package com.example.backendarsii.service;

import com.example.backendarsii.dto.requestDto.ClubRequest;
import com.example.backendarsii.dto.responseDto.ClubResponse;

import java.util.List;

public interface ClubService {
    List<ClubResponse> getAllClub();

    void deleteClub(Integer id);

    void createClub(ClubRequest clubRequest);

    ClubResponse updateClub(Integer id, ClubRequest clubRequest);

    ClubResponse getClubById(Integer clubId);
}
