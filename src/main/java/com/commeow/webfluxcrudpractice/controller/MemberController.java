package com.commeow.webfluxcrudpractice.controller;

import com.commeow.webfluxcrudpractice.dto.member.LoginRequestDto;
import com.commeow.webfluxcrudpractice.dto.member.MemberResponseDto;
import com.commeow.webfluxcrudpractice.dto.ResponseDto;
import com.commeow.webfluxcrudpractice.dto.member.SignupRequestDto;
import com.commeow.webfluxcrudpractice.service.MemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @PostMapping("/signup")
    public ResponseDto<Mono<MemberResponseDto>> signup(@Valid @RequestBody SignupRequestDto signupRequestDto){
        return memberService.signup(signupRequestDto);
    }

    @PostMapping("/login")
    public Mono<MemberResponseDto> login(@RequestBody LoginRequestDto loginRequestDto){
        return memberService.login(loginRequestDto);
    }

}
