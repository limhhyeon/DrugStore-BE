package com.github.drug_store_be.web.DTO.MainPage;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.List;

@Getter
@Builder
public class MainPageResponse {
    @Schema(description = "상품 목록", example = "[]")
    @JsonProperty("product_list")
    private List<MainPageProductResponse> product_list;
    @Schema(description = "메인 페이지 광고 이미지 정보")
    @JsonProperty("main_page_ad_img")
    private MainPageAdImg main_page_ad_img;
    @Schema(description = "전체 페이지 수", example = "47")
    private int total_pages;
    @Schema(description = "전체 상품 수", example = "139")
    private long total_elements;
    @Schema(description = "현재 페이지 번호", example = "1")
    private int current_page;
    @Schema(description = "페이지 사이즈", example = "3")
    private int page_size;
}
