package com.commeow.webfluxpractice.dto.member;

import com.commeow.webfluxpractice.entity.MemberRole;
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
    private MemberRole role;
    private LocalDateTime currentTime;
}
