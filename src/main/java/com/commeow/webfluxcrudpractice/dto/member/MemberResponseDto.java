package com.commeow.webfluxcrudpractice.dto.member;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MemberResponseDto {
    private String id;
    private String userId;
    private String nickname;
    private LocalDateTime currentTime;
}
