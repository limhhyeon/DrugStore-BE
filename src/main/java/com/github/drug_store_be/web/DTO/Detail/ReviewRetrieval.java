package com.github.drug_store_be.web.DTO.Detail;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.github.drug_store_be.repository.review.Review;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ReviewRetrieval {
    @Schema(description = "유저 닉네임", example = "jieun")
    private String nickname;
    @Schema(description = "유저 프로필 이미지 URL", example = "https://drugstorebucket.s3.ap-northeast-2.amazonaws.com/94a9bce8-a86a-4d7f-8dae-2a3a6d075eb7.jpg")
    private String profileImg;
    @Schema(description = "리뷰 점수", example = "4")
    private Integer reviewScore;
    @Schema(description = "리뷰 내용", example = "진짜 효과 짱이에요~~~")
    private String reviewContent;
    @Schema(description = "상품 이름", example = "레드 블레미쉬 클리어 수딩 크림")
    private String productName;
    @Schema(description = "상품 옵션명", example = "단품")
    private String optionName;
    @Schema(description = "리뷰 작성일", example = "2023-07-08")
    private LocalDate createAt;

    public ReviewRetrieval(Review review) {
        this.nickname = review.getUser().getNickname();
        this.profileImg=review.getUser().getProfilePic();
        this.reviewScore = review.getReviewScore();
        this.reviewContent = review.getReviewContent();
        this.productName=review.getProduct().getProductName();
        this.optionName=review.getOrders().getOptions().getOptionsName();
        this.createAt = review.getCreateAt();
    }
}
