package com.ssafy.project.api.service;

import com.ssafy.project.api.request.MyInfoRequestDto;
import com.ssafy.project.api.request.RecruitSearchCondition;
import com.ssafy.project.api.response.ApplyStatusRes;
import com.ssafy.project.api.response.MyInfoGetRes;
import com.ssafy.project.api.response.RecruitResponseListDto;
import com.ssafy.project.common.exception.ApiException;
import com.ssafy.project.common.exception.ExceptionEnum;
import com.ssafy.project.db.entity.ApplyStatus;
import com.ssafy.project.db.entity.Card;
import com.ssafy.project.db.entity.Member;
import com.ssafy.project.db.repository.ApplyStatusRepository;
import com.ssafy.project.db.repository.CardRepository;
import com.ssafy.project.db.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service("myInfoService")
@RequiredArgsConstructor
public class MyInfoServiceImpl implements MyInfoService {

    private final MemberRepository memberRepository;
    private final CardRepository cardRepository;
    private final ApplyStatusRepository applyStatueRepository;
    @Override
    @Transactional(readOnly = true)
    public MyInfoGetRes getMyInfo(String email) {

        Optional<Member> myinfo = memberRepository.findByEmail(email);
        if(!myinfo.isPresent()){
            throw new ApiException(ExceptionEnum.MEMBER_NOT_EXIST_EXCEPTION);
        }
        if(myinfo.get().getCard()==null){
            MyInfoGetRes allMyInfo =MyInfoGetRes.builder().
                    name(myinfo.get().getName()).
                    phone(myinfo.get().getPhone()).
                    email(myinfo.get().getEmail()).build();
            return allMyInfo;
        }
        Optional<Card> info = cardRepository.findById(myinfo.get().getCard().getId());

        MyInfoGetRes allMyInfo= MyInfoGetRes.builder().
                name(myinfo.get().getCard().getName()).
                phone(myinfo.get().getCard().getPhone()).
                blog(info.get().getBlog()).
                email(myinfo.get().getCard().getEmail()).
                github(info.get().getGithub()).
                introduce(info.get().getIntroduce()).
                skills(info.get().getSkills()).
                imgUrl(info.get().getImageUrl()).
                preferredJob(info.get().getPreferredJob()).build();

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
        Optional<Member> member = memberRepository.findById(id);
        if(!member.isPresent()){
            throw new ApiException(ExceptionEnum.MEMBER_NOT_EXIST_EXCEPTION);
        }

        Card card = Card.builder().
                phone(myinfo.getPhone()).
                blog(myinfo.getBlog()).
                github(myinfo.getGithub()).
                skills(myinfo.getSkills()).
                preferredJob(myinfo.getPreferredJob()).
                introduce(myinfo.getIntroduce()).
                imageUrl(myinfo.getImageUrl()).
                email(member.get().getEmail()).
                name(member.get().getName()).
                build();

        //초기 카드가 없을때
        if(member.get().getCard()==null) {
            cardRepository.save(card);
            member.get().createCard(card);
            return;
        }

        Optional<Card> info = cardRepository.findById(member.get().getCard().getId());
        info.get().createInfo(card);
    }

    @Override
    public List<ApplyStatusRes> applyStatus(Long id) {
        List<ApplyStatusRes> applyList = new ArrayList<>();
        for(ApplyStatus a : applyStatueRepository.findAllByMemberId(id)){

            ApplyStatusRes apply = ApplyStatusRes.builder().
                    recruitTitle(a.getRecruit().getRecruitTitle()).
                    step(a.getStep()).
                    status(a.getStatus()).
                    companyName(a.getRecruit().getCompany().getCompanyName()).build();
            applyList.add(apply);

        }
        return applyList;
    }


//    @Override
//    @Transactional(readOnly = true)
//    public List<RecruitResponseListDto> getReviewList(RecruitSearchCondition condition) {
//        return recruitRepository.getRecruitByLocationAndDepartment(condition);
//    }
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
