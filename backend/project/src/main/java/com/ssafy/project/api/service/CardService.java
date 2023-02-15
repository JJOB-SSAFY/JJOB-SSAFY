package com.ssafy.project.api.service;

import com.ssafy.project.api.request.CardSearchCondition;
import com.ssafy.project.api.request.CompanyRequestDto;
import com.ssafy.project.api.response.CardImageResponseDto;
import com.ssafy.project.api.response.CardResponseDto;
import com.ssafy.project.api.response.CardResponseListDto;
import com.ssafy.project.api.response.CompanyResponseDto;
import com.ssafy.project.db.entity.Card;

import java.util.List;

public interface CardService {

    List<CardResponseDto> getCard();
    List<CardResponseListDto> getCardList(CardSearchCondition condition);
    CardImageResponseDto getImage(Long id);
}
