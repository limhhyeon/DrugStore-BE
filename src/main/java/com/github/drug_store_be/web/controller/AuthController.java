package com.github.drug_store_be.web.controller;

import com.github.drug_store_be.service.auth.AuthService;
import com.github.drug_store_be.web.DTO.Auth.*;
import com.github.drug_store_be.web.DTO.ResponseDto;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/auth")
@Tag(name = "Sign Up, Login API", description = "API for sign up, login and others")

public class AuthController {
    private final AuthService authService;
    @Operation(summary = "회원가입", description = "이미지와 회원정보를 폼데이터로 받아서 회원가입 진행")
    @PostMapping(value = "/sign-up")
    public ResponseDto signUp(@RequestPart("sign") @Valid SignUp signUpRequest
            ,@RequestPart("uploadFiles") MultipartFile multipartFiles){

        return authService.signUpResult(signUpRequest,multipartFiles);
    }
    @Operation(summary = "닉네임 중복확인", description = "닉네임을 받아 db와 비교하여 중복 확인")
    @PostMapping(value = "/nickname")
    public ResponseDto nickNameCheck(@RequestBody NicknameCheck nicknameCheck){
        return authService.nicknameCheckResult(nicknameCheck);
    }
    @Operation(summary = "이메일 중복확인", description = "이메일을 받아 db와 비교하여 중복 확인")
    @PostMapping(value = "/email")
    public ResponseDto emailCheck(@RequestBody EmailCheck emailCheck){
        return authService.emailCheckResult(emailCheck);
    }
    @Operation(summary = "로그인", description = "아이디와 비밀번호를 받아 로그인 진행")
    @PostMapping(value = "/login")
    public ResponseDto login(@RequestBody Login loginRequest, HttpServletResponse httpServletResponse){
        String token = authService.login(loginRequest);
        httpServletResponse.setHeader("token", token);
        return new ResponseDto(HttpStatus.OK.value(),"Login Success");
    }
    @Operation(summary = "이메일 찾기", description = "닉네임과 전화번호를 입력하여 해당 정보에 맞는 이메일 찾아주는 기능")
    @PostMapping(value = "/find-email")
    public ResponseDto findEmail(@RequestBody FindEmail findEmail){

        return  authService.findEmailResult(findEmail);
    }
    @Operation(summary = "비밀번호 변경", description = "새로운 비빌번호로 바꿔주는 기능")
    @PutMapping(value = "/password")
    public ResponseDto changePassword(@RequestBody ChangePassword changePassword){
        return authService.changePasswordResult(changePassword);
    }
}
