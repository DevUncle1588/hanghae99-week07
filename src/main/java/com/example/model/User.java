package com.example.model;

import com.example.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "userId")
    @Id
    private Long userId;

    @Column(nullable = false)
    private String userName;

    @Column
    private String userImage;


    public User(UserDto userDto) {
        this.userName = userDto.getUserName();
        this.userImage = userDto.getUserImage();
    }
}
