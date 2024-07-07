package com.github.drug_store_be.web.controller;

import com.github.drug_store_be.service.auth.EmailService;
import com.github.drug_store_be.web.DTO.Auth.EmailAuthNumCheck;
import com.github.drug_store_be.web.DTO.Auth.EmailCheck;
import com.github.drug_store_be.web.DTO.ResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/email")
@RequiredArgsConstructor
public class EmailController {
    private final EmailService emailService;
    @Operation(summary = "인증번호 요청", description = "요청한 이메일에 인증번호 보내주기")
    @PostMapping("/send")
    public ResponseDto emailSend(@RequestBody EmailCheck emailCheck){
        return emailService.emailSendResult(emailCheck.getEmail());
    }
    @Operation(summary = "인증번호 확인", description = "받은 인증번호 동일한지 확인")
    @PostMapping("/auth-num")
    public ResponseDto authNumCheck(@RequestBody EmailAuthNumCheck emailAuthNumCheck){
        return emailService.authNumCheckResult(emailAuthNumCheck);
    }

}
