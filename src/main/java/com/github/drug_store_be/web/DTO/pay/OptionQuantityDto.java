package com.github.drug_store_be.web.DTO.pay;

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
public class OptionQuantityDto {
        @Schema(name = "option_id",description = "옵션 아이디",example = "20")
        private Integer optionId;
        @Schema(name = "quantity",description = "재고",example = "3")
        private Integer quantity;
}
