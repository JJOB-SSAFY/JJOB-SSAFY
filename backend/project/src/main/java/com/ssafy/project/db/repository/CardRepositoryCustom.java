package com.ssafy.project.db.repository;

import com.ssafy.project.api.request.CardSearchCondition;
import com.ssafy.project.api.response.CardResponseListDto;

import java.util.List;

public interface CardRepositoryCustom {
    List<CardResponseListDto> getCardBySkillsAndNameAndPreferredJob(CardSearchCondition condition);

}
