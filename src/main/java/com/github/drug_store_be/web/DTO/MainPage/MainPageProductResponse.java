package com.github.drug_store_be.web.DTO.MainPage;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MainPageProductResponse {
    @Schema(description = "상품 아이디", example = "12")
    private Integer product_id;
    @Schema(description = "상품 이름", example = "메디필 랩핑 마스크팩 70mL")
    private String product_name;
    @Schema(description = "브랜드 이름", example = "메디필")
    private String brand_name;
    @Schema(description = "상품 가격", example = "25000")
    private Integer price;
    @Schema(description = "최종 가격", example = "18000")
    private Integer final_price;
    @Schema(description = "상품 이미지 URL", example = "https://drugstorebucket.s3.ap-northeast-2.amazonaws.com/2141.png")
    private String product_img;
    @Schema(description = "좋아요 여부", example = "true")
    private boolean likes;
    @Schema(description = "베스트 상품 여부", example = "true")
    private boolean best;
    @Schema(description = "판매 중 여부", example = "true")
    private boolean sales;
}
