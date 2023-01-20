package com.ssafy.project.db.repository;

import com.ssafy.project.db.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
