package com.example.backendarsii.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActivityRequest {
    private String title;
    private String description;
    private String typeActivity;
    private String URLImage;
}
