package com.example.dto;

import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class PlayedListResponsDto {
    private Long musicId;
    private String musicTitle;
    private String artistName;
    private String imageUrl;
    private Long playCnt;

}
