package com.github.drug_store_be.web.DTO.Detail;

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
@Builder
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ProductQAndAResponse {
    @Schema(name = "question",description = "질문",example = "배송은 얼마나 걸리나요?")
    private String question;
    @Schema(name = "answer",description = "답변",example = "배송은 2일~7일정도 소요됩니다.")
    private String answer;
    @Schema(name = "userName",description = "유저 이름",example = "jieun")
    private String userName;
    @Schema(name = "email",description = "유저 이메일",example = "bang@naver.com")
    private String email;
    @Schema(name = "createdAt",description = "질문 등록일",example = "2024-07-08")
    private LocalDate createdAt;
    @Schema(name = "productName",description = "상품 이름",example = "레드 블레미쉬 클리어 수딩 크림")
    private String productName;
    @Schema(name = "brand",description = "상품 브랜드",example = "닥터지")
    private String brand;
    @Schema(name = "questionId",description = "질문 아이디",example = "1")
    private Integer questionId;
    @Schema(name = "questionStatus",description = "답변 여부",example = "답변완료")
    private String questionStatus;
}
