package com.sparta.hanghaetest.dto;

import com.sparta.hanghaetest.entity.Member;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter//얘도 추가
@NoArgsConstructor
public class MemberResponseDto {

    private Long id;
    private String name;
    private String email;
    private String pw;

    public MemberResponseDto(Member member) {
        this.id = member.getId();
        this.name = member.getName();
        this.email = member.getEmail();
        this.pw = member.getPw();
    }

}