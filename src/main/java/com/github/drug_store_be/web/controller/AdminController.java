package com.github.drug_store_be.web.controller;

import com.github.drug_store_be.repository.userDetails.CustomUserDetails;
import com.github.drug_store_be.service.admin.AdminService;
import com.github.drug_store_be.web.DTO.ResponseDto;
import com.github.drug_store_be.web.DTO.order.ProductRegisterDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {

    private final AdminService adminService;



//    @Operation(summary= "상품 등록, register product",
//        parameters = {
//            @Parameter(name="token", description= "token of user" ),
//                @Parameter(name = "productRegisterDto", description = "category id, product name, brand, price, product discount, best, product status, productPhotoList, optionsList",
//                content = @Content(schema = @Schema(implementation = ProductRegisterDto.class)))
//        },
//            responses = {
//                    @ApiResponse(description = "Product registered successfully", responseCode = "200")
//        }
//    )
@Operation(summary= "상품 등록, register product",
        parameters = {
                @Parameter(name="token", description= "token of user" ),
                @Parameter(name = "productRegisterDto", description = "category id, product name, brand, price, product discount, best, product status, productPhotoList, optionsList")
        }
)

    @PostMapping("/product")
    public ResponseDto registerProduct(
//            @ApiParam(name = "token", value= "token of user")
            @AuthenticationPrincipal CustomUserDetails customUserDetails,
            @RequestBody ProductRegisterDto productRegisterDto){
        return adminService.registerProduct(customUserDetails, productRegisterDto );
    }

}
