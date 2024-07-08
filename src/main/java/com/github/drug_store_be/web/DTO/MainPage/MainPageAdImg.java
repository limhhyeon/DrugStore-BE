package com.github.drug_store_be.web.DTO.MainPage;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Builder
@Schema(description = "MainPage 광고 이미지 URL 정보를 담고 있는 클래스")
public class MainPageAdImg {
    @Schema(description = "리뷰 베스트 상단 이미지 URL", example = "https://image.oliveyoung.co.kr/uploads/images/display/90000010001/1/7210969543105371656.jpg")
    private String review_top_image_url;
    @Schema(description = "판매 베스트 상단 이미지 URL", example = "https://image.oliveyoung.co.kr/uploads/images/display/90000010001/1/8563569463792172793.jpg")
    private String sales_top_image_url;
    @Schema(description = "좋아요 많은 상단 이미지 URL", example = "https://image.oliveyoung.co.kr/uploads/images/display/90000010001/1/7417679956940728494.jpg")
    private String likes_top_image_url;

}
