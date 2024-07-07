package com.github.drug_store_be.web.DTO.Auth;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class EmailAuthNumCheck {
    @Schema(name = "email",description = "인증번호 받은 이메일",example = "abc@naver.com")
    private String email;
    @Schema(name = "auth_num",description = "이메일에서 받은 인증번호",example = "116789")
    private Integer authNum;
}
