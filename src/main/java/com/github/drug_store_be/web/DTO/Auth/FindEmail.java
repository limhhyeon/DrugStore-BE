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
public class FindEmail {
    @Schema(name = "nickname",description = "회원가입 때 만든 닉네임",example = "콩떡빙수")
    private String nickname;
    @Schema(name = "phone_num",description = "회원가입 때 적은 자신의 휴대폰 번호",example = "01012341234")
    private String phoneNum;
}
