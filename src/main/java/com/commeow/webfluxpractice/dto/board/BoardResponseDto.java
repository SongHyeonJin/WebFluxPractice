package com.commeow.webfluxpractice.dto.board;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BoardResponseDto {
    private String id;
    private String title;
    private String content;
    private String nickname;
    private LocalDateTime currentTime;
    private LocalDateTime modifiedTime;
}
