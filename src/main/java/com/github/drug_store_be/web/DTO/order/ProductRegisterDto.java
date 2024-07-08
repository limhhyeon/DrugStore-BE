package com.github.drug_store_be.web.DTO.order;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ProductRegisterDto {
    @Schema(name = "category_id",description = "상품 카테고리 아이디",example = "1")
    private Integer categoryId;
    @Schema(name = "product_name",description = "상품 이름",example = "보습 크림")
    private String productName;
    @Schema(name = "brand",description = "브랜드",example = "대한 크림")
    private String brand;
    @Schema(name = "price",description = "가격",example = "10000")
    private Integer price;
    @Schema(name = "product_discount",description = "할인율",example = "15")
    private Integer productDiscount;
    @Schema(name = "best",description = "판매율 1등 여부",example = "true")
    private Boolean best;
    @Schema(name = "product_status",description = "판매 여부",example = "true")
    private Boolean productStatus;
    @Schema(name = "product_photo_list", description = "상품 이미지 리스트", example = "[{\"photo_url\": \"s3_1.png\", \"photo_type\": true}, {\"photo_url\": \"s3_2.png\", \"photo_type\": false}, {\"photo_url\": \"s3_3.png\", \"photo_type\": false}]")
    private List<ProductPhotoRegisterDto> productPhotoList;
    @Schema(name = "options_list", description = "상품 옵션 리스트", example = "[{\"options_name\": \"1+1 기획세트\", \"options_price\": 1000, \"stock\": 10}, {\"options_name\": \"한정 세트\", \"options_price\": 5000, \"stock\": 20}]")
    private List<OptionsRegisterDto> optionsList;
}
