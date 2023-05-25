package com.commeow.webfluxcrudpractice.dto.member;

import lombok.Getter;

@Getter
public class LoginRequestDto {
    private String userId;
    private String password;
}
