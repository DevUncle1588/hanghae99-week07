package com.example.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class PlayedList extends Timestamped{
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long playedListId;

    @ManyToOne
    @JoinColumn(name = "musicId", nullable = false)
    private Music music;

    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private User user;


}


