package com.example.backendarsii.controller.memberController;


import com.example.backendarsii.dto.requestDto.EventRequest;
import com.example.backendarsii.dto.requestDto.UpdateEventRequest;
import com.example.backendarsii.dto.responseDto.EventResponse;
import com.example.backendarsii.service.EventService;
import com.example.backendarsii.utils.Constants;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(Constants.APP_ROOT_MEMBER+"/event")
@Api(tags = "(Member) Event Management ")
@CrossOrigin("*")
public class EventMemberController {

    private final EventService eventService;

    @PostMapping
    public ResponseEntity<String> suggestEvent(@RequestBody @Valid EventRequest eventRequest){
        eventService.addEvent(eventRequest,false);
        return ResponseEntity.ok("save success !!");
    }
    @GetMapping
    public ResponseEntity<List<EventResponse>> getAllEvent(){

        return ResponseEntity.ok(eventService.getAllEvent());

    }
    @GetMapping(value = "{id}")
    public ResponseEntity<EventResponse> getEventById(@PathVariable Long id){

        return ResponseEntity.ok(eventService.getEventById(id));

    }


}
