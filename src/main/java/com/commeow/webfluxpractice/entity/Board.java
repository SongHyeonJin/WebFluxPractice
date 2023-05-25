package com.commeow.webfluxpractice.entity;

import com.commeow.webfluxpractice.dto.board.BoardRequestDto;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(value = "board_crud")
public class Board {
    @Id
    private String id;
    private String title;
    private String content;
    private String nickname;
    @CreatedDate
    private LocalDateTime currentTime;
    @LastModifiedDate
    private LocalDateTime modifiedTime;

    public Board(BoardRequestDto boardRequestDto, LocalDateTime currentTime, LocalDateTime modifiedTime){
        this.title = boardRequestDto.getTitle();
        this.content = boardRequestDto.getContent();
        this.nickname = boardRequestDto.getNickname();
        this.currentTime = currentTime;
        this.modifiedTime = modifiedTime;
    }
}
