package com.example.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Setter
@Getter
public class PlayedListResponsDto {
    private String userName;
    private Long musicId;
    private String musicTitle;
    private String artistName;
    private String imageUrl;
    private String musicUrl;
    private Long playCnt;
    private List<CommentListDto> commentListDtos;
}
