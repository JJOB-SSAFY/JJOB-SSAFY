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

        Optional<Member> myInfo = memberRepository.findByEmail(email);

        if (myInfo.isEmpty()) throw new ApiException(ExceptionEnum.MEMBER_NOT_EXIST_EXCEPTION);

        if (myInfo.get().getCard() == null) return MyInfoGetRes.from(myInfo.get());

        Optional<Card> cardInfo = cardRepository.findById(myInfo.get().getCard().getId());

        if (cardInfo.isEmpty()) throw new ApiException(ExceptionEnum.CARD_NOT_EXIST_EXCEPTION);

        return MyInfoGetRes.from(cardInfo.get());
    }

    @Override
    @Transactional
    public void changePwd(String password, Member member) {
        Optional<Member> memberOptional = memberRepository.findById(member.getId());

        if (memberOptional.isEmpty()) throw new ApiException(ExceptionEnum.MEMBER_NOT_EXIST_EXCEPTION);

        memberOptional.get().changePassword(new BCryptPasswordEncoder().encode(password));
    }

    @Override
    @Transactional
    public void changeInfo(MyInfoRequestDto myInfo, Long id) {

        Optional<Member> member = memberRepository.findById(id);

        if (member.isEmpty()) throw new ApiException(ExceptionEnum.MEMBER_NOT_EXIST_EXCEPTION);

        // 초기 카드가 없을때
        if (member.get().getCard() == null) {
            Card card = Card.of(member.get(), myInfo);
            cardRepository.save(card);
            member.get().createCard(card);
            return;
        }

        // 초기 카드가 존재할때
        Optional<Card> info = cardRepository.findById(member.get().getCard().getId());

        if (info.isEmpty()) throw new ApiException(ExceptionEnum.CARD_NOT_EXIST_EXCEPTION);

        info.get().changeInfo(myInfo);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ApplyStatusRes> applyStatus(Long id) {
        List<ApplyStatus> applyStatusList = applyStatueRepository.findAllByMemberId(id);
        return applyStatusList.stream().map(ApplyStatusRes::new).collect(toList());
    }

}
