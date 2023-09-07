package com.example.backendarsii.controller;


import com.example.backendarsii.dto.EventRequest;
import com.example.backendarsii.service.EventService;
import com.example.backendarsii.dto.EventDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
//@CrossOrigin("*")
@RequestMapping(value = "/event")
@Transactional
public class EventController {

    @Autowired
    private   EventService eventService;

    @PostMapping (value = "/event/create")
    public ResponseEntity<String> createEvent( @RequestBody @Valid EventRequest eventRequest) {
        if(eventRequest != null)
        {
            eventService.createEvent(eventRequest);
            return ResponseEntity.ok("Event created successfully");
        }else{
            return ResponseEntity.badRequest().body("Invalid event data");
        }
        //EventDto createdEvent = eventService.createEvent(eventRequest);
       // return ResponseEntity.status(HttpStatus.CREATED).body("Event created with ID: " + createdEvent.getId());
    }


    @GetMapping("/event/allevents")
    public ResponseEntity<List<EventDto>> getAllEvents() {
        List<EventDto> events = eventService.getAllEvents();
        return ResponseEntity.ok(events);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEvent(@PathVariable Integer id) {
        eventService.deleteEvent(id);
       // return ResponseEntity.noContent().build();
        return ResponseEntity.ok("Delete successfully");
    }

    //
    @GetMapping("/{eventId}")
    public ResponseEntity<EventDto> getEventById(@PathVariable Integer eventId) {
        EventDto event = eventService.getEventById(eventId);
        return ResponseEntity.ok(event);
    }

    @GetMapping("/{id}/isActive")
    public ResponseEntity<Boolean> isActive(@PathVariable Integer id) {
        EventDto event = eventService.getEventById(id);
        boolean isActive = eventService.isActive(event);
        return ResponseEntity.ok(isActive);
    }
}
