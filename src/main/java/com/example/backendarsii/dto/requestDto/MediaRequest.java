package com.example.backendarsii.dto.requestDto;

import com.example.backendarsii.utils.enumData.MediaType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MediaRequest {


    private String title;
    private String description;
    private MediaType type;
    private String image;
    private String urlPost;


}
