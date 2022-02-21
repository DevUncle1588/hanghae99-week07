package com.sparta.clone.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CommentRequestDto {

    private Long musicId;
    private Long userId;
    private String commentContent;
    private String createdAt;
    private String commentTime;

}
