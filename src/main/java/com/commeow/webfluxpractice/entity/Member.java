package com.commeow.webfluxpractice.entity;

import com.commeow.webfluxpractice.dto.member.LoginRequestDto;
import com.commeow.webfluxpractice.dto.member.SignupRequestDto;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(value = "member_crud")
public class Member implements UserDetails {
    @Id
    private String id;
    private String userId;
    private String password;
    private String nickname;
    private MemberRole role;
    @CreatedDate
    private LocalDateTime currentTime;

    public Member(String userId, String password, String nickname, MemberRole role, LocalDateTime currentTime){
        this.userId = userId;
        this.password = password;
        this.nickname = nickname;
        this.currentTime = currentTime;
        this.role = role;
    }

    public Member(LoginRequestDto loginRequestDto){
        this.userId = loginRequestDto.getUserId();
        this.password = loginRequestDto.getPassword();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return new ArrayList<>(Arrays.asList(new SimpleGrantedAuthority(this.getRole().toString())));
    }

    @Override
    public String getUsername() {
        return this.getUserId();
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
