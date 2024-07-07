package com.github.drug_store_be.web.DTO.Mypage;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReviewRequest {
    @Schema(name = "reviewContent",description = "리뷰 내용",example = "다음에도 또 살게요")
    private String reviewContent;
    @Schema(name = "reviewScore",description = "리뷰 점수",example = "5")
    private Integer reviewScore;
}
