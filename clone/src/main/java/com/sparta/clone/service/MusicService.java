package com.sparta.clone.service;

import com.sparta.clone.dto.PlayedListResponsDto;
import com.sparta.clone.model.Music;
import com.sparta.clone.model.PlayedList;
import com.sparta.clone.model.User;
import com.sparta.clone.repository.MusicRepository;
import com.sparta.clone.repository.PlayedListRepository;
import com.sparta.clone.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MusicService {
    private final MusicRepository musicRepository;
    private final PlayedListRepository playedListRepository;
    private final UserRepository userRepository;

    @Autowired
    public MusicService(MusicRepository musicRepository,
                        PlayedListRepository playedListRepository,
                        UserRepository userRepository) {
        this.musicRepository = musicRepository;
        this.playedListRepository = playedListRepository;
        this.userRepository = userRepository;
    }


    // 메인페이지 조회
    public List<Music> getAllMusics() {
        return musicRepository.findAll();
    }

    // 스트리밍페이지 조회
    public List<PlayedListResponsDto> getAllStream(Long userId) {
        Optional <User> temp = userRepository.findById(userId);
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
