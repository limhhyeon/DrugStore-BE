package com.github.drug_store_be.web.DTO.order;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ProductPhotoRegisterDto {
    @Schema(name = "photoUrl",description = "상품 이미지 저장 URL",example = "s3.png")
    private String photoUrl;
    @Schema(name = "photoType",description = "메인 이미지 여부",example = "true")
    private boolean photoType;
}
