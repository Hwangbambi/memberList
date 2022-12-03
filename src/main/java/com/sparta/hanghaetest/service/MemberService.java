package com.sparta.hanghaetest.service;

import com.sparta.hanghaetest.dto.MemberResponseDto;
import com.sparta.hanghaetest.entity.Member;
import com.sparta.hanghaetest.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public MemberResponseDto findMember(Long id) {
        Member member = memberRepository.findById(id).orElseThrow(
                () -> new NullPointerException("회원 상세 조회 실패")
        );
        return new MemberResponseDto(member);
    }

    @Transactional(readOnly = true)
    public List<MemberResponseDto> findAllMember() {
        List<Member> memberList = memberRepository.findAll();
        ArrayList<MemberResponseDto> memberResponseDtos = new ArrayList<>();

        if (memberList.isEmpty()) {
            throw new NullPointerException("조회되는 회원이 없습니다.");
        }

        for (Member member : memberList) {
            memberResponseDtos.add(new MemberResponseDto(member));
        }

        return memberResponseDtos;
    }

}