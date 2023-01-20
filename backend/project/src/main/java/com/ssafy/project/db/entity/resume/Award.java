package com.ssafy.project.db.entity.resume;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class Award {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "award_id")
    private Long id;

    @Column(nullable = false)
    private String awardName;

    @Column(nullable = false)
    private LocalDateTime awardDate;

    @Column(nullable = false)
    private String awardInstitution;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "resume_id")
    private Resume resume;
}
