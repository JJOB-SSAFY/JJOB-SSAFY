package com.ssafy.project.db.repository;

import com.ssafy.project.db.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card, Long> {

}
