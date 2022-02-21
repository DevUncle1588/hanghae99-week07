package com.sparta.clone.model;



import com.sparta.clone.dto.MusicRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class Music extends Timestamped{

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

    @Column(nullable = false)
    private String imageUrl;

    @Column(nullable = false)
    private Long playCnt;

    @Column(nullable = false)
    private Enum musicCategory;

    @Column(nullable = false)
    private String createdAt;


//    @OneToMany
//    @JoinColumn(nullable = false)
//    private PlayedList playedList;


//    @OneToMany
//    @JoinColumn(nullable = false)
//    private Comment comment;

    public Music(
            String musicTitle,
            String artistName,
            String musicUrl,
            Long playCnt,
            Enum musicCategory,
            String createdAt

            ) {
        this.musicTitle = musicTitle;
        this.artistName = artistName;
        this.musicUrl = musicUrl;
        this.playCnt = playCnt;
        this.musicCategory = musicCategory;
        this.createdAt = createdAt;

    }

    public Music(MusicRequestDto musicRequestDto) {
        this.musicTitle = musicRequestDto.getMusicTitle();
        this.artistName = musicRequestDto.getArtistName();
        this.musicUrl = musicRequestDto.getMusicUrl();
        this.imageUrl = musicRequestDto.getImageUrl();
        this.playCnt = musicRequestDto.getPlayCnt();
        this.musicCategory = musicRequestDto.getMusicCategory();
        this.createdAt = musicRequestDto.getCreatedAt();
    }

}
