package com.ssafy.project.api.service;

import com.ssafy.project.api.request.MemberJoinPostReq;
import com.ssafy.project.api.request.MemberLoginPostReq;
import com.ssafy.project.api.response.MemberLoginPostRes;
import com.ssafy.project.common.exception.ApiException;
import com.ssafy.project.common.exception.ExceptionEnum;
import com.ssafy.project.common.util.JwtTokenUtil;
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
    public void join(MemberJoinPostReq memberRegisterInfo) {

        String email = memberRegisterInfo.getEmail();

        Optional<Member> findEmail = memberRepository.findByEmail(email);

        if (findEmail.isPresent()) throw new ApiException(ExceptionEnum.MEMBER_EXIST_EXCEPTION);

        Member member = Member.from(memberRegisterInfo);

        memberRepository.save(member);
    }

    @Override
    @Transactional(readOnly = true)
    public MemberLoginPostRes login(MemberLoginPostReq loginInfo) {
        String email = loginInfo.getEmail();
        String password = loginInfo.getPassword();

        Member member = getMemberByEmail(email);

        // 로그인 요청한 유저로부터 입력된 패스워드 와 디비에 저장된 유저의 암호화된 패스워드가 같은지 확인.(유효한 패스워드인지 여부 확인)
        if (new BCryptPasswordEncoder().matches(password, member.getPassword())) {
            // 유효한 패스워드가 맞는 경우, 로그인 성공으로 응답.(액세스 토큰을 포함하여 응답값 전달)
            return MemberLoginPostRes.from(JwtTokenUtil.getToken(email));
        }
        // 유효하지 않는 패스워드인 경우, 로그인 실패로 응답.
        throw new ApiException(ExceptionEnum.PASSWORD_NOT_MATCHED_EXCEPTION);
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
