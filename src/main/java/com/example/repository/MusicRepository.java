package com.example.repository;

import com.example.model.Music;
import com.example.model.MusicCategoryEnum;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MusicRepository extends JpaRepository<Music, Long> {
    List <Music> findAllByOrderByPlayCntDesc();
    List <Music> findAllByMusicCategoryOrderByPlayCntDesc(String musicCategoryFromEnum);
//    List <Music> findAllByOrderByMusicCategoryDesc(MusicCategoryEnum musicCategoryEnum);
}
