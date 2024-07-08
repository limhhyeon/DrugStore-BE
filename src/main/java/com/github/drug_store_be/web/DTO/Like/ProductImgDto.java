package com.github.drug_store_be.web.DTO.Like;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ProductImgDto {
    @Schema(description = "이미지 URL", example = "https://drugstorebucket.s3.ap-northeast-2.amazonaws.com/ff7ecedb-a45e-42d6-a419-791f89ae4029.jpg")
    private String photoUrl;
    @Schema(description = "이미지 타입", example = "true")
    private boolean photoType;
}
