package com.example.service;

import com.example.dto.PlayedListResponsDto;
import com.example.dto.UserDto;
import com.example.model.Music;
import com.example.model.PlayedList;
import com.example.model.User;
import com.example.repository.CommentRepository;
import com.example.repository.MusicRepository;
import com.example.repository.PlayedListRepository;
import com.example.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {
    private final MusicRepository musicRepository;
    private final CommentRepository commentRepository;
    private final PlayedListRepository playedListRepository;
    private final UserRepository userRepository;


    // 메인페이지 조회
    public User regUser(UserDto userDto) {
        User user = new User(userDto);
        return userRepository.save(user);
    }

    // 스트리밍페이지 조회
    public List<PlayedListResponsDto> getAllStream(Long userId) {
        Optional<User> temp = userRepository.findById(userId);
        User user = new User();
        List<PlayedListResponsDto> playedListResponsDto = new ArrayList<>();

        if(temp.isPresent()) {
            user = temp.get();
        } else {
            throw new IllegalArgumentException("해당 유저가 없습니다!");
        }

        List<PlayedList> streamList = playedListRepository.findAllByUser(user);

        for(int i = 0; i < streamList.size(); i++) {
            PlayedListResponsDto playedListResponsDto1 = new PlayedListResponsDto();

            playedListResponsDto1.setMusicId(streamList.get(i).getMusic().getMusicId());
            playedListResponsDto1.setArtistName(streamList.get(i).getMusic().getArtistName());
            playedListResponsDto1.setMusicTitle(streamList.get(i).getMusic().getMusicTitle());
            playedListResponsDto1.setPlayCnt(streamList.get(i).getMusic().getPlayCnt());
            playedListResponsDto1.setImageUrl(streamList.get(i).getMusic().getImageUrl());

            playedListResponsDto.add(playedListResponsDto1);
        }

        return playedListResponsDto;
    }

}
