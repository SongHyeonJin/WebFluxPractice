package com.commeow.webfluxpractice.service;

import com.commeow.webfluxpractice.dto.ResponseDto;
import com.commeow.webfluxpractice.dto.TokenDto;
import com.commeow.webfluxpractice.dto.member.LoginRequestDto;
import com.commeow.webfluxpractice.dto.member.MemberResponseDto;
import com.commeow.webfluxpractice.dto.member.SignupRequestDto;
import com.commeow.webfluxpractice.entity.Member;
import com.commeow.webfluxpractice.entity.MemberRole;
import com.commeow.webfluxpractice.entity.RefreshToken;
import com.commeow.webfluxpractice.repository.MemberRepository;
import com.commeow.webfluxpractice.repository.RefreshTokenRepository;
import com.commeow.webfluxpractice.utils.AppUtils;
import com.commeow.webfluxpractice.utils.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;
    private final RefreshTokenRepository refreshTokenRepository;
//    @Override
//    public ResponseDto<Mono<MemberResponseDto>> signup(SignupRequestDto signupRequestDto) {
//        Member member = new Member(signupRequestDto, LocalDateTime.now());
//        Mono<MemberResponseDto> signupMono =  memberRepository.save(member)
//                .map(AppUtils::entityToDtoM);
//        return ResponseDto.setSuccess("회원가입 성공", signupMono);
//    }

    @Override
    public Mono<MemberResponseDto> signup(SignupRequestDto signupRequestDto) {
        MemberRole role = signupRequestDto.getRole().equals(MemberRole.STREAMER) ? MemberRole.STREAMER : MemberRole.USER;
        String password = passwordEncoder.encode(signupRequestDto.getPassword());
        String userId = signupRequestDto.getUserId();
        String nickname = signupRequestDto.getNickname();
        Member member = new Member(userId,password,nickname,role, LocalDateTime.now());
//        MemberResponseDto memberResponseDto = new MemberResponseDto(member, LocalDateTime.now());
        return memberRepository.save(member)
                .map(AppUtils::entityToDtoM);
    }

    @Override
    public Mono<ResponseEntity<String>> login(LoginRequestDto loginRequestDto) {
        return memberRepository.findByUserId(loginRequestDto.getUserId())
                .switchIfEmpty(Mono.error(new NoSuchElementException("존재하지 않는 사용자다.")))
                .flatMap(member -> {
                    if (passwordEncoder.matches(loginRequestDto.getPassword(), member.getPassword())) {
                        TokenDto tokenDto = jwtUtil.createAllToken(member.getUserId());

                        return refreshTokenRepository.findByUserId(member.getUserId())
                                .switchIfEmpty(refreshTokenRepository.save(new RefreshToken(tokenDto.getRefreshToken(), member)))
                                .flatMap(refreshToken -> refreshTokenRepository.save(refreshToken.updateToken(tokenDto.getRefreshToken())))
                                .onErrorResume(exception -> {
                                    return Mono.error(new RuntimeException("Refresh Token 저장 중 오류 발생!"));
                                })
                                .map(refreshToken -> {
                                    HttpHeaders header = new HttpHeaders();

                                    header.add(JwtUtil.ACCESS_TOKEN, tokenDto.getAccessToken());
                                    header.add(JwtUtil.REFRESH_TOKEN, tokenDto.getRefreshToken());
                                    return ResponseEntity.ok().headers(header).body("로그인 성공");
                                });
                    } else
                        return Mono.error(new IllegalArgumentException("비밀번호가 틀렸습니다."));
                });
    }
}
