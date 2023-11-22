package com.example.backendarsii.controller.memberController;

import com.example.backendarsii.dto.requestDto.UserEventRequest;
import com.example.backendarsii.dto.responseDto.EventUserResponse;
import com.example.backendarsii.dto.responseDto.UserEventResponse;
import com.example.backendarsii.service.UserEventService;
import com.example.backendarsii.utils.Constants;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping(Constants.APP_ROOT_MEMBER + "/userEvent")
@Api(tags = "(Member) User's Event management ")
@CrossOrigin("*")
public class UserEventMemberController {

    private final UserEventService userEventService;

    @PostMapping
    public ResponseEntity<Object> joinEvent(@RequestBody @Valid UserEventRequest request) {
        userEventService.joinEvent(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(
                Collections.singletonMap("message", "join success !!!"));
    }
    @PostMapping(value = "/check")
    public ResponseEntity<Object> checkjoinedEvent(@RequestBody @Valid UserEventRequest request) {
        boolean exist= userEventService.checkJoinedEvent(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                Collections.singletonMap("status",exist));
    }
    @GetMapping(value = "/users/{eventId}")
    public ResponseEntity<List<UserEventResponse>> getListOfUserByEvent(@PathVariable Long eventId) {
        return ResponseEntity.ok(userEventService.getListOfUserByEvent(eventId));
    }

    @GetMapping(value = "/events/{userId}")
    public ResponseEntity<List<EventUserResponse>> getListOfEventByUser(@PathVariable UUID userId) {
        return ResponseEntity.ok(userEventService.getListOfEventByUser(userId));
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<Object> deleteUserEvent(@PathVariable Long id) {
        userEventService.deleteUserEvent(id);

        return ResponseEntity.status(HttpStatus.CREATED).body(
                Collections.singletonMap("message", "delete success !!!"));
    }

}
