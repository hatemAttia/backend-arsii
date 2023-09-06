package com.example.backendarsii.service;

import com.example.backendarsii.dto.EventDto;

import java.util.List;

public interface EventService {
    EventDto createEvent(EventDto eventDto);

    List<EventDto> getAllEvents();

    void deleteEvent(Long eventId);

    EventDto getEventById(Long eventId);

    boolean isActive(EventDto event);
}
