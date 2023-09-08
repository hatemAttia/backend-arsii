package com.example.backendarsii.service;

import com.example.backendarsii.dto.ActivityDto;
import com.example.backendarsii.dto.ActivityRequest;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ActivityService {
    void createActivity(ActivityRequest activityRequest);
    List<ActivityDto> getAllActivity();

    ActivityDto updateActivity(Integer id, ActivityRequest activityRequest);

    void deleteActivity(Integer id);
}
