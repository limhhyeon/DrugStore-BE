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
public class OptionsRegisterDto {
    @Schema(name = "optionsName",description = "옵션 이름",example = "1+1 한정 세트")
    private String optionsName;
    @Schema(name = "optionsPrice",description = "옵션 추가 가격",example = "5000")
    private Integer optionsPrice;
    @Schema(name = "stock",description = "옵션 재고",example = "10")
    private Integer stock;
}
