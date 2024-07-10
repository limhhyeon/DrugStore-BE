package com.github.drug_store_be.web.DTO.Detail;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.github.drug_store_be.repository.product.Product;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ProductDetailResponse {
    @Schema(name = "product_id",description = "상품 아이디",example = "1")
    private Integer productId;
    @Schema(name = "product_name",description = "상품명",example = "레드 블레미쉬 클리어 수딩 크림.")
    private String productName;
    @Schema(name = "sales",description = "할인율",example = "50")
    private Integer sales;
    @Schema(name = "price",description = "가격",example = "30000")
    private Integer price;
    @Schema(name = "final_price",description = "최종가격",example = "15000")
    private Integer finalPrice;
    private List<ProductImg> productImg;
    @Schema(name = "review_count",description = "리뷰 갯수",example = "104")
    private Integer reviewCount;
    @Schema(name = "review_avg",description = "리뷰 평점",example = "4.5")
    private Double reviewAvg;
    @Schema(name = "is_like",description = "좋아요 여부",example = "true")
    private Boolean isLike;
    @Schema(name = "best",description = "베스트 상품인지 여부",example = "true")
    private Boolean best;
    @Schema(name = "brand_name",description = "브랜드네임",example = "닥터지")
    private String brandName;
    private List<ProductOption> productOptions;

//    public ProductDetailResponse(Product product, List<ProductImg> productImgs, Integer reviewCount, List<ProductOption> productOptions) {
//        this.productId = product.getProductId();
//        this.productName = product.getProductName();
//        this.sales = product.getProductDiscount();
//        this.price = product.getPrice();
//        this.finalPrice = product.getFinalPrice();
//        this.productImg = productImgs;
//        this.reviewCount = reviewCount;
//        this.reviewAvg = product.getReviewAvg();
//        this.best = product.isBest();
//        this.brandName = product.getBrand();
//        this.productOptions = productOptions;
//    }

    public static ProductDetailResponse createProductDetail(Product product, List<ProductImg> productImgs, Integer reviewCount, List<ProductOption> productOptions){
        return ProductDetailResponse.builder()
                .productId(product.getProductId())
                .productName(product.getProductName())
                .sales(product.getProductDiscount())
                .price(product.getPrice())
                .finalPrice(product.getFinalPrice())
                .productImg(productImgs)
                .reviewCount(reviewCount)
                .reviewAvg(product.getReviewAvg())
                .best(product.isBest())
                .brandName(product.getBrand())
                .productOptions(productOptions)
                .build();
    }
}
