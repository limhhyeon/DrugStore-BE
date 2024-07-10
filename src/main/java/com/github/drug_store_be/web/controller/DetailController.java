package com.github.drug_store_be.web.controller;

import com.github.drug_store_be.repository.userDetails.CustomUserDetails;
import com.github.drug_store_be.service.detail.DetailService;
import com.github.drug_store_be.service.exceptions.NotFoundException;
import com.github.drug_store_be.web.DTO.Detail.Answer;
import com.github.drug_store_be.web.DTO.Detail.ProductQAndAResponse;
import com.github.drug_store_be.web.DTO.Detail.QuestionRequest;
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
@RequestMapping(value = "/product")
@RequiredArgsConstructor
@Tag(name = "Detail API", description = "API for managing product details and Q&A")
public class DetailController {
    private final DetailService detailService;

    @Operation(summary = "상품 상세 조회", description = "상품의 이미지, 가격 등 상세 내용을 조회합니다.")
    @GetMapping
    public ResponseDto productDetail(
            @Parameter(description = "상품 아이디", required = true, example = "1")
            @RequestParam("product-id") Integer productId ,
            @Parameter(description = "인증된 사용자 정보")
            @AuthenticationPrincipal CustomUserDetails customUserDetails){

        if (customUserDetails!=null){
            return detailService.productDetailResult(productId,customUserDetails);
        }else {
            return detailService.productDetailResultByNotLogin(productId);
        }

    }

    @Operation(summary = "상품 리뷰 조회", description = "해당 상품의 리뷰를 조회합니다.")
    @GetMapping("/review/{productId}")
    public ResponseDto productReviews(
            @Parameter(description = "페이지 번호")
            @RequestParam(required = false,defaultValue = "0",value ="page")Integer pageNum,
            @Parameter(description = "정렬 기준")
            @RequestParam(required = false,defaultValue = "createAt",value ="sort")String criteria,
            @Parameter(description = "상품 아이디", required = true, example = "46")
            @PathVariable Integer productId ){
        return detailService.productReviewResult(productId,pageNum,criteria);
    }

    @Operation(summary = "Q&A 답변", description = "해당 상품의 Q&A에 관리자가 답변을 작성합니다.")
    @PostMapping("/answer")
    public ResponseDto adminAnswer(
            @Parameter(description = "질문 아이디", required = true)
            @RequestParam("question-id") Integer questionId,
            @Parameter(description = "인증된 사용자 정보")
            @AuthenticationPrincipal CustomUserDetails customUserDetails, @RequestBody Answer answer){
        return detailService.answerByAdminResult(questionId,customUserDetails,answer);

    }

    @Operation(summary = "상품 Q&A 조회", description = "해당 상품의 Q&A를 조회합니다.")
    @GetMapping("/question")
    public ResponseDto getProductQAndA(
            @Parameter(description = "상품 아이디", required = true)
            @RequestParam("product-id")Integer productId){
        try {
            List<ProductQAndAResponse> productQAndAResponseList = detailService.productQuestionAndAnswer(productId);
            return new ResponseDto(HttpStatus.OK.value(),"조회 성공",productQAndAResponseList);
        } catch (NotFoundException e) {
            return new ResponseDto(HttpStatus.BAD_REQUEST.value(),e.getMessage());
        }
    }

    @Operation(summary = "상품 Q&A 등록", description = "해당 상품의 Q&A를 로그인한 회원이 등록합니다.")
    @PostMapping("/question")
    public ResponseDto addQuestion(
            @Parameter(description = "인증된 사용자 정보")
            @AuthenticationPrincipal CustomUserDetails customUserDetails,
            @Parameter(description = "상품 아이디", required = true)
            @RequestParam("product-id")Integer productId,
            @RequestBody QuestionRequest questionRequest){
        return detailService.addQuestionResult(customUserDetails,productId, questionRequest);
    }

    @Operation(summary = "상품 Q&A 수정", description = "해당 상품의 Q&A를 작성자가 수정합니다.")
    @PutMapping("/question")
    public ResponseDto updateQuestion(
            @Parameter(description = "인증된 사용자 정보")
            @AuthenticationPrincipal CustomUserDetails customUserDetails,
            @Parameter(description = "질문 아이디", required = true)
            @RequestParam("question-id")Integer questionId,
            @RequestBody QuestionRequest questionRequest){
        return detailService.updateQuestionResult(customUserDetails, questionId,questionRequest);
    }

    @Operation(summary = "상품 Q&A 삭제", description = "해당 상품의 Q&A를 작성자가 삭제합니다.")
    @DeleteMapping("/question")
    public ResponseDto delQuestion(
            @Parameter(description = "인증된 사용자 정보")
            @AuthenticationPrincipal CustomUserDetails customUserDetails,
            @Parameter(description = "질문 아이디", required = true)
            @RequestParam("question-id")Integer questionId){
        return detailService.delQuestionResult(customUserDetails,questionId);
    }
}
