package com.example.dto;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.Column;

@Getter
public class MusicDto {
    private String musicTitle;
    private String artistName;
    private String musicUrl;
    private String imageUrl;
    private Long playCnt;
    private  String musicCategory;

    @Builder
    public MusicDto(String musicTitle, String artistName, String musicUrl, String imageUrl, Long playCnt, String musicCategory) {
        this.musicTitle = musicTitle;
        this.artistName = artistName;
        this.musicUrl = musicUrl;
        this.imageUrl = imageUrl;
        this.playCnt = playCnt;
        this.musicCategory = musicCategory;
    }
}
