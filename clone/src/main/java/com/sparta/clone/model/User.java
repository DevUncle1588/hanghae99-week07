package com.sparta.clone.model;



import com.sparta.clone.dto.UserRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Getter
@NoArgsConstructor
@Entity
public class User {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "userId")
    @Id
    private Long userId;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private  String userImage;

    public User(
            String username,
            String userImage
//            PlayedList playedList,
//            Comment comment
    ) {
        this.username = username;
        this.userImage = userImage;
//        this.playedList = playedList;
//        this.comment = comment;
    }

    private User(UserRequestDto userRequestDto) {
        this.username = userRequestDto.getUsername();
        this.userImage = userRequestDto.getUserImage();

    }

}
