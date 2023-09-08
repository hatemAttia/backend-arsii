package com.example.backendarsii.controller;


import com.example.backendarsii.dto.ActivityDto;
import com.example.backendarsii.dto.ActivityRequest;
import com.example.backendarsii.service.ActivityService;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;
@RestController
@RequestMapping(value = "/activity")
@Transactional
public class ActivityController {


    private final  ActivityService activityService;

    public ActivityController(ActivityService activityService ) {
        this.activityService = activityService ;
    }

     @PostMapping
    public ResponseEntity<String> createActivity(@RequestBody @Valid ActivityRequest activityRequest)
    {
        if (activityRequest != null) {
            activityService.createActivity(activityRequest);
            return ResponseEntity.ok("Activity created successfully");
        } else {
            return ResponseEntity.badRequest().body("Invalid activity data");
        }}

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteActivity(@PathVariable Integer id) {
        activityService.deleteActivity(id);
        //return ResponseEntity.noContent().build();
        return ResponseEntity.ok("Delete successfully");
    }

    @GetMapping("/allactivity")
    public ResponseEntity<List<ActivityDto>> getAllActivity() {
        List<ActivityDto> activities = activityService.getAllActivity();
        return ResponseEntity.ok(activities);
     }
    @PutMapping("/update/{id}")
    public ResponseEntity<ActivityDto> updateActivity(@PathVariable Integer id, @RequestBody ActivityRequest activityRequest) {
        ActivityDto updatedActivity = activityService.updateActivity(id, activityRequest);
        return ResponseEntity.ok(updatedActivity);
     }
}
