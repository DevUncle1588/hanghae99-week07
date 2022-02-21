package com.sparta.clone.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class PlayedListRequestDto {

    private Long musicId;
    private Long userId;

}
