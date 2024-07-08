package com.github.drug_store_be.web.controller;

import com.github.drug_store_be.service.service.StorageService;
import com.github.drug_store_be.web.DTO.ResponseDto;
import com.github.drug_store_be.web.DTO.awsS3.FileDto;
import com.github.drug_store_be.web.DTO.awsS3.SaveFileType;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/storage")
@RequiredArgsConstructor
@Tag(name = "File Upload API", description = "API for uploading files")

public class StorageController {
    private final StorageService storageService;

    //여러개 업로드
    @Operation(summary = "사진 업로드", description = "상품 이미지 S3서버에 업로드하기, 이미지 타입은 enum")

    @PostMapping("/multipart-files")
    public ResponseDto uploadMultipleFiles(@RequestPart("uploadFiles") List<MultipartFile> multipartFiles,
                                           @Parameter(name = "type",description = "사진 타입",example = "small")
                                           @RequestParam(required= false) Optional<SaveFileType> type
    ){
        List<FileDto> response= storageService.fileUploadAndGetUrl(multipartFiles, type.orElseGet(()-> SaveFileType.small));
        return new ResponseDto(response);
    }

    //업로드 취소(삭제)
    @Operation(summary = "사진 삭제", description = "이미지 S3서버에서 삭제하기")
    @DeleteMapping("/multipart-files")
    public ResponseDto deleteMultipleFiles(@Parameter(name = "fileUrls",description = "삭제할 사진 url",example = "https://s3.png")
                                        @RequestParam(value= "file-url") List<String> fileUrls){
        storageService.uploadCancel(fileUrls);
        return new ResponseDto();
    }

    @Operation(summary = "업로드한 사진 수정", description = "이미지 S3서버에서 기존 이미지 삭제하고 다른 이미지로 수정하기")
    @PutMapping("/multipart-files")
    public ResponseDto modifyMultipleFiles(
            @Parameter(name = "deleteFileUrls",description = "삭제할 사진 url",example = "https://s3.png")
            @RequestParam(value="file-url") List<String> deleteFileUrls,
            @RequestPart("uploadFiles") List<MultipartFile> multipartFiles,
            @Parameter(name = "type",description = "사진 타입",example = "small")
            @RequestParam(required = false) Optional<SaveFileType> type){
        List<FileDto> response= storageService.fileUploadAndGetUrl(multipartFiles, type.orElseGet(()-> SaveFileType.small));
        storageService.uploadCancel(deleteFileUrls);
        return new ResponseDto(response);
    }
}
