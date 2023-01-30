package com.ssafy.project.api.service;

import com.ssafy.project.api.request.MyInfoRequestDto;
import com.ssafy.project.api.response.MyInfoGetRes;
import com.ssafy.project.common.exception.ApiException;
import com.ssafy.project.common.exception.ExceptionEnum;
import com.ssafy.project.db.entity.Card;
import com.ssafy.project.db.entity.Member;
import com.ssafy.project.db.repository.CardRepository;
import com.ssafy.project.db.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service("myInfoService")
@RequiredArgsConstructor
public class MyInfoServiceImpl implements MyInfoService {

    private final MemberRepository memberRepository;
    private final CardRepository cardRepository;
    @Override
    @Transactional(readOnly = true)
    public MyInfoGetRes getMyInfo(String email) {

        Optional<Member> myinfo = memberRepository.findByEmail(email);
        if(!myinfo.isPresent()){
            throw new ApiException(ExceptionEnum.MEMBER_NOT_EXIST_EXCEPTION);
        }

        MyInfoGetRes allMyInfo= MyInfoGetRes.builder().
                name(myinfo.get().getCard().getName()).
                phone(myinfo.get().getCard().getPhone()).
                blog(myinfo.get().getCard().getBlog()).
                email(myinfo.get().getCard().getEmail()).
                github(myinfo.get().getCard().getGithub()).
                introduce(myinfo.get().getCard().getIntroduce()).
                skills(myinfo.get().getCard().getSkills()).
                imgUrl(myinfo.get().getCard().getImageUrl()).
                preferredJob(myinfo.get().getCard().getPreferredJob()).build();

        System.out.println(allMyInfo);
        return allMyInfo;
    }

    @Override
    @Transactional
    public void changePwd(String password, Member member) {
        Optional<Member> memberOptional = memberRepository.findById(member.getId());

        if(!memberOptional.isPresent()){
            throw new ApiException(ExceptionEnum.MEMBER_NOT_EXIST_EXCEPTION);
        }

        memberOptional.get().changePassword(new BCryptPasswordEncoder().encode(password));
    }

    @Override
    @Transactional
    public void changeInfo(MyInfoRequestDto myinfo,long id) {
        Optional<Card> info = cardRepository.findById(id);

        if(!info.isPresent()){
            throw new ApiException(ExceptionEnum.MEMBER_NOT_EXIST_EXCEPTION);
        }
        info.get().changeInfo(myinfo);
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
