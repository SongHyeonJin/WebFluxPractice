package com.commeow.webfluxpractice.service;

import com.commeow.webfluxpractice.dto.ResponseDto;
import com.commeow.webfluxpractice.dto.member.LoginRequestDto;
import com.commeow.webfluxpractice.dto.member.MemberResponseDto;
import com.commeow.webfluxpractice.dto.member.SignupRequestDto;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Mono;

public interface MemberService {
//    public ResponseDto<Mono<MemberResponseDto>> signup(SignupRequestDto signupRequestDto);
    public Mono<MemberResponseDto> signup(SignupRequestDto signupRequestDto);
    public Mono<ResponseEntity<String>> login(LoginRequestDto loginRequestDto);
}
