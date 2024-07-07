package com.github.drug_store_be.web.DTO.Auth;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Login {
    @Schema(name = "email",description = "회원가입 떄 만든 이메일",example = "abc@naver.com")
    private String email;
    @Schema(name = "password",description = "회원가입 때 만든 비밀번호",example = "345678")
    private String password;
}
