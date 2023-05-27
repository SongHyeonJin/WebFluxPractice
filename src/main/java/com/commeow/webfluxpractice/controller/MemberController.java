package com.commeow.webfluxpractice.controller;

import com.commeow.webfluxpractice.dto.member.LoginRequestDto;
import com.commeow.webfluxpractice.dto.member.MemberResponseDto;
import com.commeow.webfluxpractice.dto.ResponseDto;
import com.commeow.webfluxpractice.dto.member.SignupRequestDto;
import com.commeow.webfluxpractice.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RestController
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @PostMapping("/signup")
    public Mono<MemberResponseDto> signup(@Valid @RequestBody SignupRequestDto signupRequestDto){
//        if(errors.hasErrors()){
//            List<String> errorMessage = errors.getFieldErrors()
//                    .stream()
//                    .map(FieldError::getDefaultMessage)
//                    .collect(Collectors.toList());
//        }
        return memberService.signup(signupRequestDto);
    }

    @PostMapping("/login")
    public Mono<ResponseEntity<String>> login(@RequestBody LoginRequestDto loginRequestDto){
        return memberService.login(loginRequestDto);
    }

}
