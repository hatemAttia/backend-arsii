package com.example.backendarsii.dto.responseDto;


import com.example.backendarsii.entity.ComDoc;
import com.example.backendarsii.entity.UserEvent;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CommentDocumentResponse {
    private Integer id;
    private CommentResponse comment;
    private Instant createdAt;
    private Instant updatedAt;

    public static CommentDocumentResponse makeCommentDocumentResponse(ComDoc comDoc) {

        return CommentDocumentResponse.builder()
                .id(comDoc.getId())
                .createdAt(comDoc.getCreatedAt())
                .updatedAt(comDoc.getUpdatedAt())
               // .comment(UserResponse.makeUser(comDoc.getComment()))
                .build();
    }
}
