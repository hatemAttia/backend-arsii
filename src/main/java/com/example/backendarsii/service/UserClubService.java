package com.example.backendarsii.service;

import com.example.backendarsii.dto.requestDto.UserClubRequest;
import com.example.backendarsii.dto.responseDto.UserClubResponse;

import java.util.List;

public interface UserClubService {
    void addUserClub(UserClubRequest request);

    List<UserClubResponse> getAllClub(Long id);

    List<UserClubResponse> getAllClubByUser(Long id);

    boolean updateUserClub(Long id, UserClubRequest request);

    boolean deleteUserClub(Long id);

    void joinClub(UserClubRequest request);
    List<UserClubResponse> getListOfUserByClub(Long clubId);
}
