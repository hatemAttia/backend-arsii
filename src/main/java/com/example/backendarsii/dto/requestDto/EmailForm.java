package com.example.backendarsii.dto.requestDto;

import lombok.Data;

@Data
public class EmailForm {

    private String from;
    private String subject;
    private String content;
}
