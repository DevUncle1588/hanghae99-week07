package com.example.dto;

import com.example.model.Comment;
import com.example.model.Music;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter

public class DetailBoardReturnDto {
    private Music music;
    private List<CommentListDto> commentList;

}
