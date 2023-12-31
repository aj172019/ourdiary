package com.example.ourdiary.member.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.web.multipart.MultipartFile;

@Schema(description = "회원 등록, 수정")
public record MemberRequest(
        @Schema(description = "이름", type = "string", example = "test0000")
        String name,
        @Schema(description = "이메일", type = "string", example = "test0000@gmail.com")
        String email,
        @Schema(description = "비밀번호", type = "string", example = "0000")
        String password,
        @Schema(description = "닉네임", type = "string", example = "test0000")
        String nickname
) {
}
