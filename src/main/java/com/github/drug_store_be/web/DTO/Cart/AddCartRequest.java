package com.github.drug_store_be.web.DTO.Cart;

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
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class AddCartRequest {
    @Schema(name = "product_id",description = "상품 아이디",example = "1")
    private Integer productId;
    @Schema(name = "quantity",description = "장바구니에 추가할 개수",example = "5")
    private Integer quantity;
    @Schema(name = "options_id",description = "옵션 아이디",example = "7")
    private Integer optionsId;
}
