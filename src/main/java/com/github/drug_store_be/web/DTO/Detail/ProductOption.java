package com.github.drug_store_be.web.DTO.Detail;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.github.drug_store_be.repository.option.Options;
import com.github.drug_store_be.repository.option.OptionsRepository;
import com.github.drug_store_be.repository.product.Product;
import com.github.drug_store_be.repository.productPhoto.ProductPhoto;
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
public class ProductOption {
    @Schema(name = "optionId",description = "옵션 아이디",example = "1")
    private Integer optionId;
    @Schema(name = "option",description = "옵션",example = "실버 마그넷")
    private String option;
    @Schema(name = "optionPrice",description = "옵션 가격",example = "0")
    private Integer optionPrice;
    @Schema(name = "optionStock",description = "옵션 수량",example = "100")
    private Integer optionStock;

    public ProductOption(Options options) {
        this.optionId= options.getOptionsId();
        this.option = options.getOptionsName();
        this.optionPrice =options.getOptionsPrice();
        this.optionStock=options.getStock();
    }
    public static ProductOption ConvertEntityToDto(Options options){
        return ProductOption.builder()
                .optionId(options.getOptionsId())
                .option(options.getOptionsName())
                .optionPrice(options.getOptionsPrice())
                .optionStock(options.getStock())
                .build();
    }

    public static List<ProductOption> ConvertEntityListToDtoList(Product product, OptionsRepository optionsRepository){
        List<Options> optionsByProduct = optionsRepository.findAllByProduct(product);
        return optionsByProduct.stream().map(ProductOption::new).toList();
    }
}
