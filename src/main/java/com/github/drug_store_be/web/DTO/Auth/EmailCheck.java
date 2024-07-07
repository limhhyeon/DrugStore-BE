package com.github.drug_store_be.web.DTO.Auth;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

@Builder
public class EmailCheck {
    @Schema(name = "email",description = "사용할 이메일",example = "abc@naver.com")
    private String email;
}
