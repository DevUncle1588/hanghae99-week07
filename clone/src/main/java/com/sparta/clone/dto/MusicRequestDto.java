package com.sparta.clone.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class MusicRequestDto {

    private String musicTitle;
    private String artistName;
    private String musicUrl;
    private String imageUrl;
    private Long playCnt;
    private Enum musicCategory;
    private String createdAt;
}
