package com.github.drug_store_be.web.DTO.Detail;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.github.drug_store_be.repository.product.Product;
import com.github.drug_store_be.repository.product.ProductRepository;
import com.github.drug_store_be.repository.productPhoto.ProductPhoto;

import com.github.drug_store_be.repository.productPhoto.ProductPhotoRepository;
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
public class ProductImg {
    @Schema(name = "img_id",description = "이미지 아이디",example = "1")
    private Integer imgId;
    @Schema(name = "img_main",description = "메인이미지 여부",example = "true")
    private Boolean imgMain;
    @Schema(name = "img",description = "이미지url",example = "https://drugstorebucket.s3.ap-northeast-2.amazonaws.com/Screenshot+2024-06-16+at+19.52.00.png")
    private String img;


    public ProductImg(ProductPhoto productPhoto) {
        this.imgId = productPhoto.getProductPhotoId();
        this.imgMain = productPhoto.isPhotoType();
        this.img = productPhoto.getPhotoUrl();
    }
    public static List<ProductImg> ConvertEntityListToDtoList(Product product, ProductPhotoRepository productPhotoRepository){
        List<ProductPhoto> productPhotosByProduct=productPhotoRepository.findAllByProduct(product);
       return productPhotosByProduct.stream().map(ProductImg::new).toList();


    }
}
