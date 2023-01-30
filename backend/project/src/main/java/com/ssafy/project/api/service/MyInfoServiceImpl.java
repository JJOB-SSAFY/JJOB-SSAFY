package com.ssafy.project.api.service;

import com.ssafy.project.api.response.MyInfoGetRes;
import com.ssafy.project.db.entity.Member;
import com.ssafy.project.db.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("myInfoService")
@RequiredArgsConstructor
public class MyInfoServiceImpl implements MyInfoService {

    private final MemberRepository memberRepository;

    @Override
    @Transactional
    public MyInfoGetRes getMyInfo(String email) {
        Member myinfo = memberRepository.getByEmail(email);
        MyInfoGetRes allMyInfo= MyInfoGetRes.builder().
                name(myinfo.getCard().getName()).
                phone(myinfo.getCard().getPhone()).
                blog(myinfo.getCard().getBlog()).
                email(myinfo.getCard().getEmail()).
                github(myinfo.getCard().getGithub()).
                introduce(myinfo.getCard().getIntroduce()).
                skills(myinfo.getCard().getSkills()).
                imgUrl(myinfo.getCard().getImageUrl()).
                preferredJob(myinfo.getCard().getPreferredJob()).build();

        System.out.println(allMyInfo);
        return allMyInfo;
    }
//    @Override
//    @Transactional
//    public Member join(MemberJoinPostReq memberRegisterInfo) {
//
//        String email = memberRegisterInfo.getEmail();
//
//        Optional<Member> findEmail = memberRepository.findByEmail(email);
//
//        if (findEmail.isPresent()) throw new ApiException(ExceptionEnum.MEMBER_EXIST_EXCEPTION);
//
//        Member member = Member.from(memberRegisterInfo);
//
//        memberRepository.save(member);
//        return member;
//    }



//    @Override
//    @Transactional(readOnly = true)
//    public Member getMemberByEmail(String email) {
//        Optional<Member> findMember = memberRepository.findByEmail(email);
//
//        if (findMember.isPresent()) return findMember.get();
//
//        throw new ApiException(ExceptionEnum.MEMBER_NOT_EXIST_EXCEPTION);
//    }

//    @Override
//    @Transactional(readOnly = true)
//    public void emailCheck(String email) {
//        Optional<Member> findMember = memberRepository.findByEmail(email);
//
//        if (findMember.isPresent()) throw new ApiException(ExceptionEnum.MEMBER_EXIST_EXCEPTION);
//    }
}
