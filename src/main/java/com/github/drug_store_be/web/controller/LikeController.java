package com.github.drug_store_be.web.controller;

import com.github.drug_store_be.repository.userDetails.CustomUserDetails;
import com.github.drug_store_be.service.like.LikeService;
import com.github.drug_store_be.web.DTO.Like.LikeRequest;
import com.github.drug_store_be.web.DTO.Like.MyLikesResponse;
import com.github.drug_store_be.web.DTO.ResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/likes")
public class LikeController {

    private final LikeService likeService;

    @Operation(summary = "내가 좋아요한 목록 조회", description = "내가 좋아요 추가한 목록 조회합니다.")
    @GetMapping
    public ResponseDto getLike(@AuthenticationPrincipal CustomUserDetails customUserDetails) {
        List<MyLikesResponse> myLikesResponseList = likeService.getMyLikes(customUserDetails);
        return new ResponseDto(HttpStatus.OK.value(),"조회 성공", myLikesResponseList );
    }

    @Operation(summary = "좋아요 추가", description = "관심있는 상품 좋아요 추가합니다.")
    @PostMapping
    public ResponseDto addLike(@AuthenticationPrincipal CustomUserDetails customUserDetails,
                               @RequestBody LikeRequest likeRequest) {
        return likeService.addMyLike(customUserDetails, likeRequest.getProductId());
    }

    @Operation(summary = "좋아요 삭제", description = "관심있었던 상품 좋아요 삭제합니다.")
    @DeleteMapping
    public ResponseDto deleteLike(@AuthenticationPrincipal CustomUserDetails customUserDetails,
                                  @RequestBody LikeRequest likeRequest) {
        return likeService.deleteMyLike(customUserDetails, likeRequest.getProductId());
    }
}
