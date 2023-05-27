package com.commeow.webfluxpractice.dto.member;

import com.commeow.webfluxpractice.entity.MemberRole;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Getter
@NoArgsConstructor
public class SignupRequestDto {
    @NotNull
    @Size(min = 4, max = 10, message = "아이디는 4~10자 사이여야 합니다.")
    @Pattern(regexp = "^[a-z0-9]*$", message = "아이디는 영문, 숫자만 가능합니다.")
    private String userId;
    @NotNull
    @Size(min = 8, max =15, message = "비밀번호는 8~15자 사이여야 합니다.")
    @Pattern(regexp = "(?=.*[0-9])(?=.*[a-zA-Z])(?=.*\\W)(?=\\S+$).{8,15}", message = "비밀번호는 영문 대,소문자, 숫자, 특수문자를 사용하세요.")
    private String password;
    @NotNull
    @Size(min = 2, max = 10, message = "닉네임은 2~10자 사이여야 합니다.")
    private String nickname;
    @NotNull
    private MemberRole role;
}
