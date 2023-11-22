package com.example.backendarsii.service;

import com.example.backendarsii.dto.requestDto.UserEventRequest;
import com.example.backendarsii.dto.responseDto.EventUserResponse;
import com.example.backendarsii.dto.responseDto.UserEventResponse;

import java.util.List;
import java.util.UUID;

public interface UserEventService {
    void joinEvent(UserEventRequest request);

    List<EventUserResponse> getListOfEventByUser(UUID userId);

    List<UserEventResponse> getListOfUserByEvent(Long eventId);

    void deleteUserEvent(Long id);

    boolean checkJoinedEvent(UserEventRequest request);
}
