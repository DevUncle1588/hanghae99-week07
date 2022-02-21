package com.sparta.clone.repository;

import com.sparta.clone.model.PlayedList;
import com.sparta.clone.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlayedListRepository extends JpaRepository<PlayedList, Long> {
    List<PlayedList> findAllByUser (User user);
}
