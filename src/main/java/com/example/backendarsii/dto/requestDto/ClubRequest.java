package com.example.backendarsii.dto.requestDto;


import com.example.backendarsii.utils.enumData.Post;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClubRequest {

    private Integer id;
    private String name;
    private String logo;
    private String location;
    private String description;
    private String contact;
    private Date date;
    private String member;
    @Enumerated(EnumType.STRING)
    private Post post;
    private boolean status;
}
