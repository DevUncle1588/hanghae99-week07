package com.sparta.clone.service;

import com.sparta.clone.repository.PlayedListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayedListService {
    private final PlayedListRepository playedListRepository;

    @Autowired
    public PlayedListService(PlayedListRepository playedListRepository) {
        this.playedListRepository = playedListRepository;
    }
}
