package com.github.drug_store_be.web.DTO.Auth;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Builder
public class ChangePassword {
    @Schema(name = "email",description = "회원가입 떄 만든 이메일",example = "abc@naver.com")
    private String email;
    @Schema(name = "new_password",description = "새로운 비밀번호",example = "12341234")
    private String newPassword;
    @Schema(name = "new_password_check",description = "새로운 비밀번호 확인",example = "12341234")
    private String newPasswordCheck;
}
