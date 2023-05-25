package com.commeow.webfluxpractice.entity;

import com.commeow.webfluxpractice.dto.member.LoginRequestDto;
import com.commeow.webfluxpractice.dto.member.SignupRequestDto;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(value = "member_crud")
public class Member {
    @Id
    private String id;
    private String userId;
    private String password;
    private String nickname;
    @CreatedDate
    private LocalDateTime currentTime;

    public Member(SignupRequestDto signupRequestDto, LocalDateTime currentTime){
        this.userId = signupRequestDto.getUserId();
        this.password = signupRequestDto.getPassword();
        this.nickname = signupRequestDto.getNickname();
        this.currentTime = currentTime;
    }

    public Member(LoginRequestDto loginRequestDto){
        this.userId = loginRequestDto.getUserId();
        this.password = loginRequestDto.getPassword();
    }
}
