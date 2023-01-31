package com.ssafy.project.db.repository;


import com.ssafy.project.db.entity.ApplyStatus;
import com.ssafy.project.db.entity.Member;
import com.ssafy.project.db.entity.QApplyStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ApplyStatusRepository extends JpaRepository<ApplyStatus, Long> {
    @Query(value="select a from ApplyStatus a join a.member m where m.id =:memberId")
    List<ApplyStatus> getApplyStatusByMemberId(@Param("memberId") Long memberId);
}
