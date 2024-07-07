package com.github.drug_store_be.web.DTO.Auth;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Builder
public class SignUp {
    @Schema(name = "name",description = "본인 이름",example = "홍길동")
    private String name;
    @Schema(name = "nickname",description = "사용할 닉네임",example = "콩떡빙수")
    private String nickname;
    @Schema(name = "email",description = "본인 이메일",example = "abc@naver.com")
    private String email;
    @Schema(name = "password",description = "비밀번호",example = "345678")
    private String password;
    @Schema(name = "password_check",description = "비밀번호 확인",example = "345678")
    private String passwordCheck;
    @Schema(name = "birthday",description = "본인 생일",example = "2000-07-07")
    private LocalDate birthday;
    @Schema(name = "phone_number",description = "본인 휴대폰 번호",example = "01012341234")
    private String phoneNumber;
    @Schema(name = "address",description = "본인 주소",example = "서울 강남구")
    private String address;
    @Schema(name = "profile_pic",description = "프로필 이미지",example = "이미지 링크")
    private String profilePic;

}
