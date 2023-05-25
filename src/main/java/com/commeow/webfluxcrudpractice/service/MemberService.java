package com.commeow.webfluxcrudpractice.service;

import com.commeow.webfluxcrudpractice.dto.member.LoginRequestDto;
import com.commeow.webfluxcrudpractice.dto.member.MemberResponseDto;
import com.commeow.webfluxcrudpractice.dto.ResponseDto;
import com.commeow.webfluxcrudpractice.dto.member.SignupRequestDto;
import reactor.core.publisher.Mono;

public interface MemberService {
    public ResponseDto<Mono<MemberResponseDto>> signup(SignupRequestDto signupRequestDto);
//    public Mono<MemberResponseDto> signup(SignupRequestDto signupRequestDto);
    public Mono<MemberResponseDto> login(LoginRequestDto loginRequestDto);
}
