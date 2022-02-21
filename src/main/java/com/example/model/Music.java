package com.example.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Music extends Timestamped {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "musicId")
    @Id
    private Long musicId;

    @Column(nullable = false)
    private String musicTitle;

    @Column(nullable = false)
    private String artistName;

    @Column(nullable = false)
    private String musicUrl;

    @Column
    private String imageUrl;

    @Column(nullable = false)
    private Long playCnt;

    @Column(nullable = false)
    private  String musicCategory;




}
