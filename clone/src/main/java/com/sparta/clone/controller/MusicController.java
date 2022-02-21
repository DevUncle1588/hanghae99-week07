package com.sparta.clone.controller;


import com.sparta.clone.dto.PlayedListResponsDto;
import com.sparta.clone.model.Music;
import com.sparta.clone.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
public class MusicController {

    private final MusicService musicService;

    @Autowired
    public MusicController(MusicService musicService) {
        this.musicService = musicService;
    }

    // 메인페이지 조회
    @GetMapping("/main")
    public List<Music> getAllMusics() {
        return musicService.getAllMusics();
    }

    // 스트리밍페이지 조회
    @GetMapping("/stream/{userId}")
    public List<PlayedListResponsDto> getAllStream(@PathVariable Long userId) {
        return musicService.getAllStream(userId);
    }

}
