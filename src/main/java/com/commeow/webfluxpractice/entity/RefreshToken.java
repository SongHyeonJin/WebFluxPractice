package com.commeow.webfluxpractice.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@NoArgsConstructor
@Document(value = "refreshtoken")
public class RefreshToken {
    @Id
    private String id;

    private String refreshToken;
    private String userId;

    public RefreshToken(String refreshToken, Member member){
        this.refreshToken = refreshToken;
        this.userId = member.getUserId();
    }

    public RefreshToken updateToken(String token){
        this.refreshToken = token;
        return this;
    }
}
