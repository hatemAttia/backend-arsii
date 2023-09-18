package com.example.backendarsii.service;

import com.example.backendarsii.dto.requestDto.UserEventRequest;
import com.example.backendarsii.dto.responseDto.EventUserResponse;
import com.example.backendarsii.dto.responseDto.UserEventResponse;

import java.util.List;

public interface UserEventService {
    void joinEvent(UserEventRequest request);

    List<EventUserResponse> getListOfEventByUser(Long userId);

    List<UserEventResponse> getListOfUserByEvent(Long eventId);

    void deleteUserEvent(Long id);
}
