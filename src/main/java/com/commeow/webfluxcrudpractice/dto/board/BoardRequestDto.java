package com.commeow.webfluxcrudpractice.dto.board;

import lombok.Getter;

@Getter
public class BoardRequestDto {
    private String title;
    private String content;
    private String nickname;

}
