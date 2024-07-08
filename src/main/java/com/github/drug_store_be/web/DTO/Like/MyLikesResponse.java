package com.github.drug_store_be.web.DTO.Like;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class MyLikesResponse {
    @Schema(description = "상품 아이디", example = "13")
    private Integer productId;
    @Schema(description = "상품 이름", example = "레드 블레미쉬 클리어 수딩 크림")
    private String productName;
    @Schema(description = "이미지 URL", example = "https://drugstorebucket.s3.ap-northeast-2.amazonaws.com/profile3.png")
    private String productImg;
    @Schema(description = "가격", example = "30000")
    private Integer price;
    @Schema(description = "최종 가격", example = "20000")
    private Integer finalPrice;
    @Schema(description = "브랜드 이름", example = "닥터지")
    private String brandName;
    @Schema(description = "좋아요 여부", example = "true")
    private boolean likes;

}
