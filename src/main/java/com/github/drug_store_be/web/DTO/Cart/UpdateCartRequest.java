package com.github.drug_store_be.web.DTO.Cart;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class UpdateCartRequest {
    @Schema(name = "cart_id",description = "카드 아이디",example = "1")
    private Integer cartId;
    @Schema(name = "options_id",description = "수정할 옵션 아이디",example = "8")
    private Integer optionsId;
    @Schema(name = "quantity",description = "수정할 상품 개수",example = "3")
    private Integer quantity;
    @Schema(name = "options_name",description = "옵션 이름",example = "블루")
    private String optionsName;
}
