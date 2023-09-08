package com.example.backendarsii.service.serviceImpl;

import com.example.backendarsii.dto.ActivityDto;
import com.example.backendarsii.dto.ActivityRequest;
import com.example.backendarsii.entity.Activity;
import com.example.backendarsii.exception.NotFoundException;
import com.example.backendarsii.repository.ActivityRepository;
import com.example.backendarsii.service.ActivityService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class ActivityServiceImpl implements ActivityService {
  private final ActivityRepository activityRepository;

    @Override
    public void createActivity(@org.jetbrains.annotations.NotNull ActivityRequest activityRequest) {
        Activity activity = Activity.builder()
                .title(activityRequest.getTitle())
                .description(activityRequest.getDescription())
                .typeActivity(activityRequest.getTypeActivity())
                .URLImage(activityRequest.getURLImage())
                .build();
               activityRepository.save(activity);
    }

    @Override
    public void deleteActivity(Integer id) {
        activityRepository.deleteById(id);
    }

    @Override
    public List<ActivityDto> getAllActivity() {
        List<Activity> activities = activityRepository.findAllActivities();
        List<ActivityDto> activityDtos = new ArrayList<>();
        for (Activity activity : activities) {
            ActivityDto activityDto = ActivityDto.makeActivity(activity);
            activityDtos.add(activityDto);
        }
        return activityDtos;
    }

    @Override
    public ActivityDto updateActivity(Integer id, ActivityRequest activityRequest) {
        Optional<Activity> optionalActivity = activityRepository.findById(id);

        if (optionalActivity.isPresent()) {
            Activity existingActivity = optionalActivity.get();
            existingActivity.setTitle(activityRequest.getTitle());
            existingActivity.setDescription(activityRequest.getDescription());
            existingActivity.setTypeActivity(activityRequest.getTypeActivity());
            existingActivity.setURLImage(activityRequest.getURLImage());
            activityRepository.save(existingActivity);
            return ActivityDto.makeActivity(existingActivity);
        } else {
            throw new NotFoundException("Activity with ID : " + id);
        }
    }
}
