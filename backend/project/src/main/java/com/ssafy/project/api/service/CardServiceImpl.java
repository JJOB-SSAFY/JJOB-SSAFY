package com.ssafy.project.api.service;

import com.ssafy.project.api.request.CardSearchCondition;
import com.ssafy.project.api.response.CardImageResponseDto;
import com.ssafy.project.api.response.CardResponseDto;
import com.ssafy.project.api.response.CardResponseListDto;
import com.ssafy.project.api.response.MainResponseDto;
import com.ssafy.project.common.exception.ApiException;
import com.ssafy.project.common.exception.ExceptionEnum;
import com.ssafy.project.db.entity.Card;
import com.ssafy.project.db.entity.Member;
import com.ssafy.project.db.repository.CardRepository;
import com.ssafy.project.db.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@Service("cardService")
@RequiredArgsConstructor
@Slf4j
public class CardServiceImpl implements CardService {

    private final CardRepository cardRepository;

    private final MemberRepository memberRepository;

    @Override
    @Transactional(readOnly = true)
    public List<CardResponseDto> getCard() {

        List<Card> cardList = cardRepository.findAllByVisible(true);
        return cardList.stream().map(CardResponseDto::new).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<CardResponseListDto> getCardList(CardSearchCondition condition) {
        return cardRepository.getCardBySkillsAndNameAndPreferredJobAndVisible(condition);
    }

    @Override
    @Transactional(readOnly = true)
    public CardImageResponseDto getImage(String email) {
        Member member = memberRepository.findByEmail(email)
                .orElseThrow(() -> new ApiException(ExceptionEnum.MEMBER_NOT_EXIST_EXCEPTION));

        return CardImageResponseDto.builder()
                .profileImg(member.getCard().getImageUrl())
                .build();
    }

}
