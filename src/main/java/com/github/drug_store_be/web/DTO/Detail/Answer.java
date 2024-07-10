package com.github.drug_store_be.web.DTO.Detail;

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
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Answer {
    @Schema(name = "message",description = "Q&A 답변",example = "배송은 2일~7일정도 소요됩니다.")
    private String message;
}
