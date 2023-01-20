package com.ssafy.project.db.entity.resume;

import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "skill_id")
    private Long id;

    @Column(nullable = false)
    private String skillName;

    @Column(nullable = false)
    private String skillLevel;

    @Column(nullable = false)
    private String detail;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "resume_id")
    private Resume resume;

}
