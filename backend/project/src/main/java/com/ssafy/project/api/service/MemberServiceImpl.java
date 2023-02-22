package com.ssafy.project.api.service;

import com.ssafy.project.api.request.MemberJoinPostReq;
import com.ssafy.project.api.request.MemberLoginPostReq;
import com.ssafy.project.api.response.MemberLoginPostRes;
import com.ssafy.project.common.exception.ApiException;
import com.ssafy.project.common.exception.ExceptionEnum;
import com.ssafy.project.common.util.JWTUtil;
import com.ssafy.project.db.entity.Card;
import com.ssafy.project.db.entity.Company;
import com.ssafy.project.db.entity.Member;
import com.ssafy.project.db.entity.MemberRoleEnum;
import com.ssafy.project.db.repository.CardRepository;
import com.ssafy.project.db.repository.CompanyRepository;
import com.ssafy.project.db.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.Set;

import static com.ssafy.project.db.entity.MemberRoleEnum.*;
import static org.springframework.util.StringUtils.hasText;

@Service("memberService")
@RequiredArgsConstructor
@Slf4j
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;
    private final JWTUtil jwtUtil;
    private final CompanyRepository companyRepository;
    private final CardRepository cardRepository;

    @Override
    @Transactional
    public void join(MemberJoinPostReq joinInfo) {

        String email = joinInfo.getEmail();
        String companyName = joinInfo.getCompanyName();
        String name = joinInfo.getName();

        Optional<Member> findEmail = memberRepository.findByEmail(email);

        if (findEmail.isPresent()) throw new ApiException(ExceptionEnum.MEMBER_EXIST_EXCEPTION);

        Card card = createCard(email, name);

        Member member = Member.from(joinInfo, card);

        if (hasText(companyName)) {
            Company company = companyExistCheck(companyName);
            member.addCompany(company);
            member.addMemberRole(USER);
            member.addMemberRole(COMPANY);
        } else {
            member.addMemberRole(USER);
        }

        memberRepository.save(member);
    }

    private Card createCard(String email, String name) {
        Card card = new Card();
        card.setImageUrl("https://firebasestorage.googleapis.com/v0/b/jjob-4c01e.appspot.com/o/images%2Fprofile-removebg.png?alt=media&token=167eb21d-70e0-4571-b044-97b72fa172f2");
        card.setName(name);
        card.setEmail(email);
        cardRepository.save(card);
        return card;
    }

    @Override
    @Transactional(readOnly = true)
    public MemberLoginPostRes login(MemberLoginPostReq loginInfo) {
        String email = loginInfo.getEmail();
        String password = loginInfo.getPassword();

        Member member = memberRepository.findByEmail(email)
                .orElseThrow(() -> new ApiException(ExceptionEnum.MEMBER_NOT_EXIST_EXCEPTION));

        Set<MemberRoleEnum> roleSet = member.getRoleSet();

        // 로그인 요청한 유저로부터 입력된 패스워드 와 디비에 저장된 유저의 암호화된 패스워드가 같은지 확인.(유효한 패스워드인지 여부 확인)
        if (new BCryptPasswordEncoder().matches(password, member.getPassword())) {
            // 유효한 패스워드가 맞는 경우, 로그인 성공으로 응답.(액세스 토큰을 포함하여 응답값 전달)
            if (member.getCompany() == null) {
                return MemberLoginPostRes.from(jwtUtil.createToken(email), member.getName(), getRole(roleSet));
            }

            return MemberLoginPostRes.from(jwtUtil.createToken(email), member.getName(), getRole(roleSet), member.getCompany().getId());
        }

        // 유효하지 않는 패스워드인 경우, 로그인 실패로 응답.
        throw new ApiException(ExceptionEnum.PASSWORD_NOT_MATCHED_EXCEPTION);
    }

    @Override
    @Transactional(readOnly = true)
    public void emailCheck(String email) {
        Optional<Member> findMember = memberRepository.findByEmail(email);

        if (findMember.isPresent()) throw new ApiException(ExceptionEnum.MEMBER_EXIST_EXCEPTION);
    }

    private Company companyExistCheck(String companyName) {
        return companyRepository.findByCompanyName(companyName)
                .orElseThrow(() -> new ApiException(ExceptionEnum.COMPANY_NOT_EXIST_EXCEPTION));
    }

    private String getRole(Set<MemberRoleEnum> roleSet) {
        if (roleSet.contains(ADMIN)) {
            return "ADMIN";
        } else if (roleSet.contains(COMPANY)) {
            return "COMPANY";
        }
        return "USER";
    }

}
