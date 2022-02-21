package com.sparta.clone.model;



import com.sparta.clone.dto.PlayedListRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Getter
@NoArgsConstructor
@Entity
public class PlayedList extends Timestamped {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long playedListId;

    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "musicId", nullable = false)
    private Music music;

    public PlayedList(User user, Music music) {
        this.user = user;
        this.music = music;
    }

}
