package com.github.drug_store_be.web.DTO.pay;

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

public class PayRequestDto {
        @Schema(name = "option_quantity_dto", description = "결제할 상품 옵션 리스트", example = "[{\"options_id\": \"20\", \"quantity\": 3}, {\"options_id\": \"7\", \"quantity\": 5}")
        private List<OptionQuantityDto> optionQuantityDto;
        @Schema(name = "total_price",description = "최종 결제 가격",example = "50000")
        private Integer totalPrice;
}
