package com.example.repository;

import com.example.model.Music;
import com.example.model.PlayedList;
import com.example.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlayedListRepository extends JpaRepository<PlayedList, Long> {
    List<PlayedList> findAllByMusic(Music music);
    List<PlayedList> findAllByUser (User user);
}
