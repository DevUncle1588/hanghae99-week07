package com.example.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public class CommentListDto {
    private String userImage;
    private Long commentId;
    private String commentUser;
    private String commentContent;
    private String commentTime;
    private String createdAt;
}
