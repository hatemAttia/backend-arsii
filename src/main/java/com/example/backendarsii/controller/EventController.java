package com.example.backendarsii.controller;


import com.example.backendarsii.entity.Event;
import com.example.backendarsii.service.EventService;
import com.example.backendarsii.dto.EventDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/event")
public class EventController {

    public  EventService eventService;

    @PostMapping (value = "/event/create")
    public ResponseEntity<String> createEvent(@RequestBody EventDto eventDto) {
        EventDto createdEvent = eventService.createEvent(eventDto);
        return ResponseEntity.status(HttpStatus.CREATED).body("Event created with ID: " + createdEvent.getId());
    }
    @GetMapping("/event/allevents")
    public ResponseEntity<List<EventDto>> getAllEvents() {
        List<EventDto> events = eventService.getAllEvents();
        return ResponseEntity.ok(events);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteEvent(@PathVariable Long id) {
        eventService.deleteEvent(id);
        return ResponseEntity.noContent().build();
    }
    //
    @GetMapping("/{eventId}")
    public ResponseEntity<EventDto> getEventById(@PathVariable Long eventId) {
        EventDto event = eventService.getEventById(eventId);
        return ResponseEntity.ok(event);
    }

    @GetMapping("/{id}/isActive")
    public ResponseEntity<Boolean> isActive(@PathVariable Long id) {
        EventDto event = eventService.getEventById(id);
        boolean isActive = eventService.isActive(event);
        return ResponseEntity.ok(isActive);
    }
}
