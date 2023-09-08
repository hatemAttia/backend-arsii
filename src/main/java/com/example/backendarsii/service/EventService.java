package com.example.backendarsii.service;

import com.example.backendarsii.dto.requestDto.EventRequest;
import com.example.backendarsii.dto.requestDto.UpdateEventRequest;
import com.example.backendarsii.dto.responseDto.EventResponse;

import java.util.List;

public interface EventService {

    void addEvent(EventRequest eventRequest,boolean status);
    List<EventResponse> getAllEvent();
    EventResponse getEventById(Long id);
    void updateEvent (Long id, UpdateEventRequest updateEventRequest);
    void deleteEvent(Long id);

}
