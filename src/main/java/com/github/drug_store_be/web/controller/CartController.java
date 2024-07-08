package com.github.drug_store_be.web.controller;

import com.github.drug_store_be.repository.userDetails.CustomUserDetails;
import com.github.drug_store_be.service.cart.CartService;
import com.github.drug_store_be.web.DTO.Cart.AddCartRequest;
import com.github.drug_store_be.web.DTO.Cart.CartResponse;
import com.github.drug_store_be.web.DTO.Cart.UpdateCartRequest;
import com.github.drug_store_be.web.DTO.ResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/cart")
@Tag(name = "Cart API", description = "API for get, post, update, delete cart")

public class CartController {
    private final CartService cartService;

    @Operation(summary = "나의 카트 조회", description = "토큰으로 나의 카트에 들어있는 상품 조회하기")
    @GetMapping
    public ResponseDto getCartItems(@AuthenticationPrincipal CustomUserDetails customUserDetails) {
        List<CartResponse> cartItems = cartService.findAllCarts(customUserDetails);
        return new ResponseDto(HttpStatus.OK.value(), "Cart items retrieved successfully", cartItems);
    }

    @Operation(summary = "카트 추가", description = "카트에 상품 추가하기")

    @PostMapping
    public ResponseDto addCartItem(@AuthenticationPrincipal CustomUserDetails customUserDetails,
                                   @RequestBody List<AddCartRequest> cartRequests) {
        return cartService.addCartItem(customUserDetails, cartRequests);
    }

    @Operation(summary = "카트 수정", description = "카트 상품의 개수, 옵션 수정하기")
    @PutMapping
    public ResponseDto updateCartItem(@AuthenticationPrincipal CustomUserDetails customUserDetails,
                                      @RequestBody UpdateCartRequest updateCartRequest){
        return cartService.updateCartItem(customUserDetails, updateCartRequest);
    }

    @Operation(summary = "카트 상품 삭제", description = "카트에서 하나의 상품 삭제")
    @DeleteMapping("/{cartId}")
    public ResponseDto removeCartItem(@AuthenticationPrincipal CustomUserDetails customUserDetails,
            @Parameter(name = "cartId",description = "삭제하고자 하는 상품의 카트 아이디",example = "1")@PathVariable("cartId") Integer cartId) {
        return cartService.removeCartItem(customUserDetails, cartId);
    }
    @Operation(summary = "카트 비우기", description = "카트 전체 비우기")
    @DeleteMapping("/empty")
    public ResponseDto clearCart(@AuthenticationPrincipal CustomUserDetails customUserDetails){
        return cartService.clearCart(customUserDetails);
    }
}
