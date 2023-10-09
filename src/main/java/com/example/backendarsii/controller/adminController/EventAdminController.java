package com.example.backendarsii.controller.adminController;


import com.example.backendarsii.dto.requestDto.EventRequest;
import com.example.backendarsii.dto.requestDto.UpdateEventRequest;
import com.example.backendarsii.dto.responseDto.EventResponse;
import com.example.backendarsii.service.EventService;
import com.example.backendarsii.utils.Constants;
import com.example.backendarsii.utils.enumData.EventType;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.util.Collections;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(Constants.APP_ROOT_ADMIN + "/event")
@Api(tags = "(Admin) Event Management ")
@CrossOrigin("*")
public class EventAdminController {

    private final EventService eventService;

    @PostMapping
    public ResponseEntity<Object> createEvent(@RequestBody EventRequest eventRequest) {
        eventService.addEvent(eventRequest);

        return ResponseEntity.status(HttpStatus.CREATED).body(
                Collections.singletonMap("message", "save success !!"));
    }

    @GetMapping
    public ResponseEntity<List<EventResponse>> getAllEvent(@RequestParam(required = false)  EventType type) {
        return ResponseEntity.ok(eventService.getAllEvent(type));
    }
    @GetMapping(value = "/activity")
    public ResponseEntity<List<EventResponse>> getAllActivity() {
        return ResponseEntity.ok(eventService.getAllActivity());
    }



    @GetMapping(value = "{id}")
    public ResponseEntity<EventResponse> getEventById(@PathVariable Long id) {
        return ResponseEntity.ok(eventService.getEventById(id));
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<Object> updateEvent(
            @RequestBody @Valid UpdateEventRequest request,
            @PathVariable Long id) {
        eventService.updateEvent(id, request);

        return ResponseEntity.status(HttpStatus.CREATED).body(
                Collections.singletonMap("message", "update success !!"));
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<Object> deleteEvent(@PathVariable Long id) {
        eventService.deleteEvent(id);

        return ResponseEntity.status(HttpStatus.CREATED).body(
                Collections.singletonMap("message", "delete success !!"));
    }


}
