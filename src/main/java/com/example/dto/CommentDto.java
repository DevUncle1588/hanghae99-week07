package com.example.dto;

import lombok.Getter;

@Getter
public class CommentDto {
    private Long userId;
    private String commentContent;
    private String commentTime;
}
