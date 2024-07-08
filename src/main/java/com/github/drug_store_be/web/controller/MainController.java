package com.github.drug_store_be.web.controller;

import com.github.drug_store_be.service.main.MainService;
import com.github.drug_store_be.web.DTO.MainPage.MainPageProductResponse;
import com.github.drug_store_be.web.DTO.MainPage.MainPageResponse;
import com.github.drug_store_be.web.DTO.ResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/main")
public class MainController {

    private final MainService mainservice;

    @Operation(summary = "상품 전체 목록 조회", description = "등록된 상품의 전체 목록을 조회합니다.")
    @GetMapping
    public ResponseDto mainPage(
            @Parameter(
                    description = "정렬 기준",
                    required = false,
                    in = ParameterIn.QUERY,
                    schema = @Schema(type = "string", defaultValue = "sales")
            )
            @RequestParam(name = "sortby", defaultValue = "sales") String sortBy,
                                @PageableDefault(page = 0, size = 24) Pageable pageable) {
        MainPageResponse mainPageResponse= mainservice.mainpage(sortBy,pageable);
        return new ResponseDto(HttpStatus.OK.value(), "메인 페이지 조회에 성공했습니다.",mainPageResponse);
    }


    @Operation(summary = "카테고리별 조회", description = "상품을 카테고리별로 조회합니다.")
    @GetMapping(path = "/category/{category}")
    public ResponseDto mainPageCategory(
            @Parameter(
                    description = "카테고리 번호",
                    required = true,
                    in = ParameterIn.PATH,
                    schema = @Schema(type = "integer")
            )
            @PathVariable(value = "category") int category,
            @Parameter(
                    description = "정렬 기준",
                    required = false,
                    in = ParameterIn.QUERY,
                    schema = @Schema(type = "string", defaultValue = "sales")
            )
            @RequestParam(name = "sortby", defaultValue = "sales")  String sortBy, @PageableDefault(page = 0, size = 24) Pageable pageable) {
        Page<MainPageProductResponse> mainPageProductResponse=mainservice.CategoryPage(category, sortBy,pageable);
        return new ResponseDto(HttpStatus.OK.value(),"카테고리 페이지 조회에 성공했습니다.",mainPageProductResponse);
    }

    @Operation(summary = "상품 검색", description = "키워드로 상품 검색하여 해당하는 상품만 조회합니다.")
    @GetMapping(path = "/find")
    public ResponseDto mainPageSearch(
            @Parameter(
                    description = "검색 키워드",
                    required = true,
                    in = ParameterIn.QUERY,
                    schema = @Schema(type = "string", defaultValue = "")
            )
            @RequestParam(value = "keyword", defaultValue = "", required = true) String keyword,
            @Parameter(
                    description = "정렬 기준",
                    required = false,
                    in = ParameterIn.QUERY,
                    schema = @Schema(type = "string", defaultValue = "sales")
            )
            @RequestParam(name = "sortby", defaultValue = "sales") String sortBy, @PageableDefault(page = 0, size = 24) Pageable pageable ) {
        Page<MainPageProductResponse> mainPageProductResponse=mainservice.findPage(keyword,sortBy,pageable);
        return new ResponseDto(HttpStatus.OK.value(),"검색에 성공했습니다.",mainPageProductResponse);
    }
}