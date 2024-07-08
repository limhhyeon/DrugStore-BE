package com.github.drug_store_be.web.DTO.awsS3;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class FileDto {
    @Schema(name = "file_name",description = "파일 이름",example = "abc.png")
    private String fileName;
    @Schema(name = "file_url",description = "S3에 저장된 파일 url",example = "https://abc.png")
    private String fileUrl;
}
