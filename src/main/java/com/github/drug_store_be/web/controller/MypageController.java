package com.github.drug_store_be.web.controller;

import com.github.drug_store_be.repository.userDetails.CustomUserDetails;
import com.github.drug_store_be.service.MyPage.MypageService;
import com.github.drug_store_be.service.exceptions.NotFoundException;
import com.github.drug_store_be.service.exceptions.ReviewException;
import com.github.drug_store_be.web.DTO.Mypage.ReviewRequest;
import com.github.drug_store_be.web.DTO.ResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequiredArgsConstructor
@RequestMapping(value="/mypage")
@Tag(name = "MyPage API", description = "API for get, post, update, delete reviews, my information, orders, questions")
public class MypageController {
    private final MypageService mypageService;
    @Operation(summary = "리뷰 작성", description = "구매한 상품에 대해 리뷰 작성")
    @PostMapping("/review/{ordersId}")
    public ResponseDto AddReview(@AuthenticationPrincipal CustomUserDetails customUserDetails,
                                 @RequestBody ReviewRequest reviewRequest,
                                 @Parameter(name = "ordersId",description = "구매내역의 id",example = "1")
                                     @PathVariable("ordersId") Integer ordersId) {
        try {
            return mypageService.addReview(customUserDetails, reviewRequest, ordersId);
        } catch (ReviewException e) {
            return new ResponseDto(HttpStatus.BAD_REQUEST.value(), e.getMessage(), null);
        }
    }
    @Operation(summary = "리뷰 수정", description = "작성한 리뷰에 대한 수정")
    @PutMapping("/review/{ordersId}")
    public ResponseDto UpdateReview(@AuthenticationPrincipal CustomUserDetails customUserDetails,
                                    @RequestBody ReviewRequest reviewRequest,
                                    @Parameter(name = "ordersId",description = "구매내역의 id",example = "1")@PathVariable("ordersId") Integer ordersId) throws ReviewException {
        return mypageService.updateReview(customUserDetails, reviewRequest, ordersId);
    }
    @Operation(summary = "리뷰 삭제", description = "작성한 리뷰 삭제")
    @DeleteMapping("/review/{ordersId}")
    public ResponseDto deleteReview(@AuthenticationPrincipal CustomUserDetails customUserDetails,
                                    @Parameter(name = "ordersId",description = "구매내역의 id",example = "1")@PathVariable("ordersId") Integer ordersId) {
        try {
            return mypageService.deleteReview(customUserDetails, ordersId);
        } catch (NotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }
    @Operation(summary = "유저 정보 조회", description = "회원가입할 때 작성한 유저 정보 조회")
    @GetMapping("/userInfo")
    public ResponseDto MyPageUserDetail(@AuthenticationPrincipal CustomUserDetails customUserDetails) {
        return mypageService.findUserDetail(customUserDetails);
    }
    @Operation(summary = "구매내역 조회", description = "자신이 산 구매내역 조회")
    @GetMapping("/order")
    public ResponseDto MyPageOrderList(@AuthenticationPrincipal CustomUserDetails customUserDetails, @Parameter(name = "pageable",description = "페이지조회") Pageable pageable) {
        return mypageService.findAllOrders(customUserDetails, pageable);
    }
    @Operation(summary = "작성한 리뷰 조회", description = "자신이 작성한 모든 리뷰에 대한 조회")
    @GetMapping("/reviews")
    public ResponseDto getReviews(@AuthenticationPrincipal CustomUserDetails customUserDetails, @Parameter(name = "pageable",description = "페이지조회") Pageable pageable) {
        return mypageService.findAllReviews(customUserDetails, pageable);
    }
    @Operation(summary = "쿠폰 조회", description = "자신이 가지고 있는 쿠폰 조회")
    @GetMapping("/coupon")
    public ResponseDto myCoupon(@AuthenticationPrincipal CustomUserDetails customUserDetails) {
        return mypageService.findAllCoupon(customUserDetails);
    }
    @Operation(summary = "작성한 Q&A 조회", description = "자신이 작성한 모든 Q&A에 대한 조회")
    @GetMapping("/question")
    public ResponseDto ReviewList(@AuthenticationPrincipal CustomUserDetails customUserDetails, @Parameter(name = "pageable",description = "페이지조회")Pageable pageable) {
        return mypageService.findAllQnA(customUserDetails,pageable);
    }
}
