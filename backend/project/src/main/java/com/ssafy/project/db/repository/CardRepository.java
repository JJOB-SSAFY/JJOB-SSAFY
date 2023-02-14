package com.ssafy.project.db.repository;

import com.ssafy.project.api.response.CardResponseDto;
import com.ssafy.project.db.entity.ApplyStatus;
import com.ssafy.project.db.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CardRepository extends JpaRepository<Card, Long>, CardRepositoryCustom {
    List<Card> findAllByVisible(boolean visible);

}
