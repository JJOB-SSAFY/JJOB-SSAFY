package com.ssafy.project.api.service;

import com.ssafy.project.api.request.MemberJoinPostReq;
import com.ssafy.project.db.entity.Member;
import com.ssafy.project.db.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
        Member member = Member.builder()
                .email(memberRegisterInfo.getEmail())
                .password(new BCryptPasswordEncoder().encode(memberRegisterInfo.getPassword()))
                .name(memberRegisterInfo.getName())
                .phone(memberRegisterInfo.getPhone())
                .build();

        memberRepository.save(member);
        return member;
    }

    @Override
    @Transactional(readOnly = true)
    public Member getMemberByEmail(String email) {
        Optional<Member> findMember = memberRepository.findMemberByEmail(email);

        if (findMember.isPresent()) {
            return findMember.get();
        }

        return null;
    }
}
