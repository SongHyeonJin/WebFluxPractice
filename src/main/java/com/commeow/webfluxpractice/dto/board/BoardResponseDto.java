package com.commeow.webfluxpractice.dto.board;


import com.commeow.webfluxpractice.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BoardResponseDto {
    private Long id;
    private String title;
    private String content;
    private String nickname;
    private LocalDateTime currentTime;
    private LocalDateTime modifiedTime;
    private Member member;
}
