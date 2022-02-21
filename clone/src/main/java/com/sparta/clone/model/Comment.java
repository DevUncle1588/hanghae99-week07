package com.sparta.clone.model;



import com.sparta.clone.dto.CommentRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;



@Getter
@NoArgsConstructor
@Entity
public class Comment extends Timestamped{

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long commentId;

    @Column(nullable = false)
    private Long musicId;

    @Column(nullable = false)
    private Long userId;

    @Column(nullable = false)
    private String commentContent;

    @Column(nullable = false)
    private String createdAt;

    @Column(nullable = false)
    private String commentTime;

    @ManyToOne
    @JoinColumn(nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Music music;

    public Comment(
            Long musicId,
            Long userId,
            String commentContent,
            String createdAt,
            String commentTime,
            User user,
            Music music
    ) {
        this.musicId = musicId;
        this.userId = userId;
        this.commentContent = commentContent;
        this.createdAt = createdAt;
        this.commentTime = commentTime;
        this.user = user;
        this.music = music;
    }

    public Comment(CommentRequestDto commentRequestDto) {
        this.musicId = commentRequestDto.getMusicId();
        this.userId = commentRequestDto.getUserId();
        this.commentContent = commentRequestDto.getCommentContent();
        this.createdAt = commentRequestDto.getCreatedAt();
        this.commentTime = commentRequestDto.getCommentTime();
    }

}
