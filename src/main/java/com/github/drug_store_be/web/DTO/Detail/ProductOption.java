package com.github.drug_store_be.web.DTO.Detail;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.github.drug_store_be.repository.option.Options;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ProductOption {
    private Integer optionId;
    private String option;
    private Integer optionPrice;

    public ProductOption(Options options) {
        this.optionId= options.getOptionsId();
        this.option = options.getOptionsName();
        this.optionPrice =options.getOptionsPrice();
    }
}
