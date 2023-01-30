package com.ssafy.project.api.service;

import com.ssafy.project.api.request.MemberJoinPostReq;
import com.ssafy.project.common.exception.ApiException;
import com.ssafy.project.common.exception.ExceptionEnum;
import com.ssafy.project.db.entity.Member;
import com.ssafy.project.db.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service("memberService")
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    @Override
    @Transactional
    public Member join(MemberJoinPostReq memberRegisterInfo) {

        String email = memberRegisterInfo.getEmail();

        Optional<Member> findEmail = memberRepository.findByEmail(email);

        if (findEmail.isPresent()) throw new ApiException(ExceptionEnum.MEMBER_EXIST_EXCEPTION);

        Member member = Member.from(memberRegisterInfo);

        memberRepository.save(member);
        return member;
    }

    @Override
    @Transactional(readOnly = true)
    public Member getMemberByEmail(String email) {
        Optional<Member> findMember = memberRepository.findByEmail(email);

        if (findMember.isPresent()) return findMember.get();

        throw new ApiException(ExceptionEnum.MEMBER_NOT_EXIST_EXCEPTION);
    }

    @Override
    @Transactional(readOnly = true)
    public void emailCheck(String email) {
        Optional<Member> findMember = memberRepository.findByEmail(email);

        if (findMember.isPresent()) throw new ApiException(ExceptionEnum.MEMBER_EXIST_EXCEPTION);
    }
}
