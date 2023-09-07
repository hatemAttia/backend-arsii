package com.example.backendarsii.service;

import com.example.backendarsii.dto.EventDto;
import com.example.backendarsii.dto.EventRequest;

import java.util.List;

public interface EventService {
    void createEvent(EventRequest eventRequest);

    List<EventDto> getAllEvents();

    void deleteEvent(Integer eventId);

    EventDto getEventById(Integer eventId);

    boolean isActive(EventDto event);
}
