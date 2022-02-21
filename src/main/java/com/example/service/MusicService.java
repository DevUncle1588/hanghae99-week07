package com.example.service;

import com.example.dto.*;
import com.example.model.Comment;
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
public class MusicService {
    private final MusicRepository musicRepository;
    private final CommentRepository commentRepository;
    private final PlayedListRepository playedListRepository;
    private final UserRepository userRepository;


    // 메인페이지 조회
    public List<Music> getAllMusics() {
        return musicRepository.findAll();
    }

    // 스트리밍페이지 조회
    public List<PlayedListResponsDto> getAllStream(Long userId) {
        Optional <User> temp = userRepository.findById(userId);
        User user;
        List<PlayedListResponsDto> playedListResponsDto = new ArrayList<>();

        if(temp.isPresent()) {
            user = temp.get();
        } else {
            throw new IllegalArgumentException("해당 유저가 없습니다!");
        }

        List<PlayedList> streamList = playedListRepository.findAllByUser(user);

        for(int i = 0; i < streamList.size(); i++) {
            PlayedListResponsDto playedListResponsDto1 = new PlayedListResponsDto();

            playedListResponsDto1.setUserName(user.getUserName());
            playedListResponsDto1.setMusicId(streamList.get(i).getMusic().getMusicId());
            playedListResponsDto1.setArtistName(streamList.get(i).getMusic().getArtistName());
            playedListResponsDto1.setMusicTitle(streamList.get(i).getMusic().getMusicTitle());
            playedListResponsDto1.setPlayCnt(streamList.get(i).getMusic().getPlayCnt());
            playedListResponsDto1.setImageUrl(streamList.get(i).getMusic().getImageUrl());
            playedListResponsDto1.setMusicUrl(streamList.get(i).getMusic().getMusicUrl());
            playedListResponsDto.add(playedListResponsDto1);
        }

        return playedListResponsDto;
    }



    // 음원 하나 조회
    public DetailBoardReturnDto getBoards(Long musicId) {
        // 음원 하나와 해당 음원에 등록된 댓글 응답으로 리턴하기 위한 객체 선언
        DetailBoardReturnDto detailBoardReturnDto = new DetailBoardReturnDto();
        // 음원 하나
        Music music;
        // 응답 dto 넣을 List 객체 선언
        List<CommentListDto> commentListDtos = new ArrayList<>();
        // 음원 하나 DB에서 가져오기
        Optional<Music> temp = musicRepository.findById(musicId);

        // 음원이 DB에 존재하는지 확인
        if(temp.isPresent()) {
            music = temp.get();
        }
        else {
            throw new IllegalArgumentException("해당 음악이 존재하지 않습니다.");
        }
        // dto에 음원 하나 set
        detailBoardReturnDto.setMusic(music);
        // 해당 음원에 달린 댓글 List로 가져오기
        List<Comment> comments = commentRepository.findAllByMusic(music);

        // 가져온 댓글 List로 dto에 set
        for (int i = 0; i <comments.size(); i++) {
            CommentListDto commentListDto = new CommentListDto();

            commentListDto.setCommentId(comments.get(i).getCommentId());
            commentListDto.setCommentContent(comments.get(i).getCommentContent());
            commentListDto.setCommentUser(comments.get(i).getUser().getUserName());
            commentListDto.setCreatedAt(comments.get(i).getCreatedAt());
            commentListDto.setUserImage(comments.get(i).getUser().getUserImage());
            commentListDto.setCommentTime(comments.get(i).getCommentTime());

            commentListDtos.add(commentListDto);
        }
        // 응답 dto List에 set
        detailBoardReturnDto.setCommentList(commentListDtos);
        return detailBoardReturnDto;
    }

    public void getPlay(Long musicId, Long userId) {
        Optional<Music> temp = musicRepository.findById(musicId);
        Optional<User> temp2 = userRepository.findById(userId);
        List<PlayedList> playedLists;
        Music music;
        User user;
        PlayedList playedList = new PlayedList();
        Boolean notChecked = true;

        if(temp.isPresent() && temp2.isPresent()) {
            music = temp.get();
            user = temp2.get();
        }
        else {
            throw new IllegalArgumentException("해당 음악 또는 유저가 존재하지 않습니다.");
        }
        music.setPlayCnt(music.getPlayCnt() + 1);
        // playCnt +1 변경사항을 업데이트하기 위한 save
        musicRepository.save(music);
        playedLists = playedListRepository.findAllByMusic(music);

        if(!playedLists.isEmpty()) {
            for (int i = 0; i < playedLists.size(); i++) {
                if (playedLists.get(i).getUser().equals(user)) {
                    notChecked = false;
                    break;
                }

            }
        }
        if(notChecked) {
            playedList.setMusic(music);
            playedList.setUser(user);
            playedListRepository.save(playedList);
        }

    }

    public CommentListDto writeComment(Long musicId, CommentDto commentDto) {
        Comment comment = new Comment();
        Comment tempComment;
        CommentListDto commentListDto = new CommentListDto();
        User user;
        Music music;

        Optional<User> temp = userRepository.findById(commentDto.getUserId());
        Optional<Music> temp2 = musicRepository.findById(musicId);
        if(temp.isPresent() && temp2.isPresent()) {
            user = temp.get();
            music = temp2.get();
        }
        else {
            throw new IllegalArgumentException("해당 음악 또는 유저가 존재하지 않습니다.");
        }
        comment.setMusic(music);
        comment.setUser(user);
        comment.setCommentContent(commentDto.getCommentContent());
        comment.setCommentTime(commentDto.getCommentTime());

        tempComment = commentRepository.save(comment);
        commentListDto.setCommentId(tempComment.getCommentId());
        commentListDto.setCommentUser(user.getUserName());
        commentListDto.setCommentContent(tempComment.getCommentContent());
        commentListDto.setUserImage(user.getUserImage());
        commentListDto.setCreatedAt(tempComment.getCreatedAt());
        commentListDto.setCommentTime(tempComment.getCommentTime());

        return commentListDto;
    }

    public Music uploadMusic(MusicDto musicDto, String musicS3Url) {
        Music music = new Music();
        music.setMusicTitle(musicDto.getMusicTitle());
        music.setMusicUrl(musicS3Url);
        music.setMusicCategory(musicDto.getMusicCategory());
        music.setPlayCnt(0L);
        music.setArtistName(musicDto.getArtistName());
        music.setImageUrl(musicDto.getImageUrl());

        return musicRepository.save(music);

    }
}


