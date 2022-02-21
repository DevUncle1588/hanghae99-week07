package com.example.controller;

import com.example.dto.*;
import com.example.model.Music;
import com.example.dto.MusicDto;
import com.example.model.User;
import com.example.s3aws.S3Uploader;
import com.example.service.MusicService;
import com.example.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


@RequiredArgsConstructor
@RestController
//@Controller
public class DetailBoardController {
    private final MusicService musicService;
    private final S3Uploader s3Uploader;
    private final UserService userService;


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

    @GetMapping("/music/{musicId}")
    public DetailBoardReturnDto getBoards(@PathVariable Long musicId) {
        return musicService.getBoards(musicId);
    }

    @PostMapping("/music/{musicId}")
    public void getPlay(@PathVariable Long musicId, @RequestBody UserIdDto userIdDto) {
        Long userId = userIdDto.getUserId();
        musicService.getPlay(musicId, userId);
    }

    @PostMapping("/music/{musicId}/comment")
    public CommentListDto writeComment(@PathVariable Long musicId, @RequestBody CommentDto commentDto) {
        return musicService.writeComment(musicId, commentDto);
    }

    @PostMapping("/music")
//    public Music uploadMusic(@RequestParam("images") MultipartFile multipartFile, @RequestBody MusicDto musicDto) {
    public Music uploadMusic(@ModelAttribute MusicDto musicDto, @RequestParam(required = false)MultipartFile multipartFile) {
//        System.out.println("뮤지션="+request.getMusicDto().getArtistName());
        String musicS3Url = s3Uploader.upload(multipartFile, "static");
        return musicService.uploadMusic(musicDto, musicS3Url);
    }

    @PostMapping("/user")
    public User regUser(@RequestBody UserDto userDto) {
        return userService.regUser(userDto);
    }


}
