package com.example.backendarsii.controller;

import com.example.backendarsii.dto.responseDto.EventResponse;
import com.example.backendarsii.dto.responseDto.FormationResponse;
import com.example.backendarsii.dto.responseDto.PartnerResponse;
import com.example.backendarsii.dto.responseDto.UserResponse;
import com.example.backendarsii.service.EventService;
import com.example.backendarsii.service.FormationService;
import com.example.backendarsii.service.PartnerService;
import com.example.backendarsii.service.UserService;
import com.example.backendarsii.utils.Constants;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(Constants.APP_ROOT + "/visitor")
@RequiredArgsConstructor
@Api(tags = "visitor ")
@CrossOrigin("*")
public class VisitorController {

    public final UserService userService;
    public final EventService eventService;
    public final FormationService formationService;
    public final PartnerService partnerService;

    @GetMapping(value = "allMember")
    public ResponseEntity<List<UserResponse>> getAllMember() {
        return ResponseEntity.ok(userService.getAllMember());
    }
    @GetMapping(value = "allEvent")
    public ResponseEntity<List<EventResponse>> getAllEvent() {

        return ResponseEntity.ok(eventService.getAllEvent());

    }
    @GetMapping(value = "allFormation")
    public ResponseEntity<List<FormationResponse>> getAllFormation() {
        return ResponseEntity.ok(formationService.getAllFormation());
    }
    @GetMapping("allPartner")
    public ResponseEntity<List<PartnerResponse>> getAllPartner() {
        return ResponseEntity.ok(partnerService.getAllPartner());
    }

}
