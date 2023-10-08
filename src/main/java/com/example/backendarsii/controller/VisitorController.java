package com.example.backendarsii.controller;

import com.example.backendarsii.dto.requestDto.EmailForm;
import com.example.backendarsii.dto.responseDto.*;
import com.example.backendarsii.service.*;
import com.example.backendarsii.utils.Constants;
import com.example.backendarsii.utils.EmailUtil;
import com.example.backendarsii.utils.enumData.EventType;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(Constants.APP_ROOT + "/visitor")
@RequiredArgsConstructor
@Api(tags = "visitor ")
@CrossOrigin("*")
public class VisitorController {

    public final UserService userService;
    public final EventService eventService;

    public final PartnerService partnerService;
    public final OpportunityService opportunityService;
    public final ClubService clubService;
    private final MediaService mediaService;
    private final EmailUtil emailUtil;


    @GetMapping(value = "allMember")
    public ResponseEntity<List<UserResponse>> getAllMember() {
        return ResponseEntity.ok(userService.getAllMember());
    }
    @GetMapping(value = "allEvent/{type}")
    public ResponseEntity<List<EventResponse>> getAllEvent(@PathVariable EventType type) {
        return ResponseEntity.ok(eventService.getAllEvent(type));
    }

    @GetMapping("allPartner")
    public ResponseEntity<List<PartnerResponse>> getAllPartner() {
        return ResponseEntity.ok(partnerService.getAllPartner());
    }

    @GetMapping("allOportunity")
    public ResponseEntity<List<OpportunityResponse>> getAllOpportunity (){
        return ResponseEntity.ok(opportunityService.getAllOpportunity());
    }


    @GetMapping(value = "event/{id}")
    public ResponseEntity<EventResponse> getEventById(@PathVariable Long id) {
        return ResponseEntity.ok(eventService.getEventById(id));
    }

    @GetMapping("/allClub")
    public ResponseEntity<List<ClubResponse>> getAllClub() {
        List<ClubResponse> clubs = clubService.getAllClub();
        return ResponseEntity.ok(clubs);
    }
    @GetMapping(value = "allMedia")
    public ResponseEntity<List<MediaResponse>> getAllMedia() {
        return ResponseEntity.ok(mediaService.getAllMedia());
    }

    @GetMapping(value = "media/{id}")
    public ResponseEntity<MediaResponse> getMediaById(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(mediaService.getMediaById(id));
    }
    @PostMapping(value = "sendEmail")
    public ResponseEntity<String> sendEmail(@RequestBody EmailForm form) {

       emailUtil.sendEmail("attia00018@gmail.com", form.getFrom(), form.getSubject(), form.getContent());
       return ResponseEntity.ok("OK !!!!!!");
    }
}
