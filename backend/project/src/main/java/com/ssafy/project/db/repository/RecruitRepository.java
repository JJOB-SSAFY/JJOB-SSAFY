package com.ssafy.project.db.repository;

import com.ssafy.project.db.entity.Recruit;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecruitRepository extends JpaRepository<Recruit, Long>, RecruitRepositoryCustom {

    List<Recruit> findAllByOrderByRecruitEndDateDesc(Pageable pageable);
}
