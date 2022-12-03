package com.sparta.hanghaetest.controller;

import com.sparta.hanghaetest.dto.MemberResponseDto;
import com.sparta.hanghaetest.service.MemberService;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    //특정 회원 정보를 조회하는 API
    @GetMapping("/member/{id}")
    public MemberResponseDto getMemberInfo(@PathVariable Long id) {
        return memberService.findMember(id);
    }

    //회원 전체 조회 API
    @GetMapping("/member")
    public List<MemberResponseDto> getMemberList() {
        return memberService.findAllMember();
    }

}