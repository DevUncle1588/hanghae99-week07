package com.example.dto;

import com.example.model.Music;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class MainResponseDto {

    private List<Music> allMusicList;
    private List<Music> topMusicList;
    private List<Music> hiphopCategoryMusic;
    private List<Music> rockCategoryMusic;


}