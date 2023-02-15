package com.ssafy.project.api.service;

import com.ssafy.project.api.request.MyInfoRequestDto;
import com.ssafy.project.api.response.ApplyStatusRes;
import com.ssafy.project.api.response.MyInfoGetRes;
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

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Service("myInfoService")
@RequiredArgsConstructor
public class MyInfoServiceImpl implements MyInfoService {

    private final MemberRepository memberRepository;
    private final CardRepository cardRepository;
    private final ApplyStatusRepository applyStatueRepository;

    @Override
    @Transactional(readOnly = true)
    public MyInfoGetRes getMyInfo(String email) {

        Member member = memberRepository.findByEmail(email)
                .orElseThrow(() -> new ApiException(ExceptionEnum.MEMBER_NOT_EXIST_EXCEPTION));

        Card cardInfo = cardRepository.findById(member.getCard().getId())
                .orElseThrow(() -> new ApiException(ExceptionEnum.CARD_NOT_EXIST_EXCEPTION));

        return MyInfoGetRes.from(cardInfo);
    }

    @Override
    @Transactional
    public String changePwd(String change, String current, Long memberId) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new ApiException(ExceptionEnum.MEMBER_NOT_EXIST_EXCEPTION));

        if (new BCryptPasswordEncoder().matches(current, member.getPassword())) {
            member.changePassword(new BCryptPasswordEncoder().encode(change));
            return "Success";
        }else{
            return "Fail";
        }
    }

    @Override
    @Transactional
    public void changeInfo(MyInfoRequestDto myInfo, Long id) {

        Member member = memberRepository.findById(id)
                .orElseThrow(() -> new ApiException(ExceptionEnum.MEMBER_NOT_EXIST_EXCEPTION));

        Card card = cardRepository.findById(member.getCard().getId())
                .orElseThrow(() -> new ApiException(ExceptionEnum.CARD_NOT_EXIST_EXCEPTION));

        card.changeInfo(myInfo);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ApplyStatusRes> applyStatus(Long id) {
        List<ApplyStatus> applyStatusList = applyStatueRepository.findAllByMemberId(id);
        return applyStatusList.stream().map(ApplyStatusRes::new).collect(toList());
    }

}
