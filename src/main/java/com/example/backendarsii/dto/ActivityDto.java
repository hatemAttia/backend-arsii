package com.example.backendarsii.dto;

import com.example.backendarsii.entity.Activity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ActivityDto {
    private Integer id;
    private String title;
    private String description;
    private String typeActivity;
    private String URLImage;
    private Instant createdAt;
    private Instant updatedAt;

    public static ActivityDto makeActivity(Activity activity){
        return ActivityDto.builder()
                .id(activity.getId())
                .title(activity.getTitle())
                .description(activity.getDescription())
                .typeActivity(activity.getTypeActivity())
                .URLImage(activity.getURLImage())
                .createdAt(activity.getCreatedAt())
                .updatedAt(activity.getUpdatedAt())
                .build();
    }
}
