package com.github.drug_store_be.web.controller;

import com.github.drug_store_be.repository.userDetails.CustomUserDetails;
import com.github.drug_store_be.service.admin.AdminService;
import com.github.drug_store_be.web.DTO.ResponseDto;
import com.github.drug_store_be.web.DTO.order.ProductRegisterDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin")
@Tag(name = "Product Register API", description = "API for registering products of sellers")
public class AdminController {

    private final AdminService adminService;


    @Operation(summary= "상품 등록", description = "권한을 가진 유저가 판매 위한 상품 등록")
    @PostMapping("/product")
    public ResponseDto registerProduct(@AuthenticationPrincipal CustomUserDetails customUserDetails,
                                       @RequestBody ProductRegisterDto productRegisterDto){
        return adminService.registerProduct(customUserDetails, productRegisterDto );
    }

}
