package com.commeow.webfluxpractice.service;

import com.commeow.webfluxpractice.dto.member.LoginRequestDto;
import com.commeow.webfluxpractice.dto.member.MemberResponseDto;
import com.commeow.webfluxpractice.dto.ResponseDto;
import com.commeow.webfluxpractice.dto.member.SignupRequestDto;
import com.commeow.webfluxpractice.entity.Member;
import com.commeow.webfluxpractice.repository.MemberRepository;
import com.commeow.webfluxpractice.utils.AppUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{
    private final MemberRepository memberRepository;
    @Override
    public ResponseDto<Mono<MemberResponseDto>> signup(SignupRequestDto signupRequestDto) {
        Member member = new Member(signupRequestDto, LocalDateTime.now());
        Mono<MemberResponseDto> signupMono =  memberRepository.save(member)
                .map(AppUtils::entityToDtoM);
        return ResponseDto.setSuccess("회원가입 성공", signupMono);
    }

//    @Override
//    public Mono<MemberResponseDto> signup(SignupRequestDto signupRequestDto) {
//        Member member = new Member(signupRequestDto, LocalDateTime.now());
//        return memberRepository.save(member)
//                .map(AppUtils::entityToDtoM);
//    }

    @Override
    public Mono<MemberResponseDto> login(LoginRequestDto loginRequestDto) {
        Member member = new Member(loginRequestDto);
        return null;
    }
}
