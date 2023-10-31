package com.example.backendarsii.controller.memberController;


import com.example.backendarsii.dto.requestDto.EventRequest;
import com.example.backendarsii.dto.responseDto.EventResponse;
import com.example.backendarsii.service.EventService;
import com.example.backendarsii.utils.Constants;
import com.example.backendarsii.utils.enumData.EventType;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(Constants.APP_ROOT_MEMBER + "/event")
@Api(tags = "(Member) Event Management ")
@CrossOrigin("*")
public class EventMemberController {

    private final EventService eventService;



//    @GetMapping(value = "{type}")
//    public ResponseEntity<List<EventResponse>> getAllEvent(@PathVariable EventType type) {
//        return ResponseEntity.ok(eventService.getAllEvent(type));
//
//    }

    @GetMapping
    public ResponseEntity<List<EventResponse>> getAllEvent(@RequestParam(required = false)  EventType type) {
        return ResponseEntity.ok(eventService.getAllEvent(type));
    }
    @GetMapping(value = "{id}")
    public ResponseEntity<EventResponse> getEventById(@PathVariable Long id) {

        return ResponseEntity.ok(eventService.getEventById(id));

    }


}
