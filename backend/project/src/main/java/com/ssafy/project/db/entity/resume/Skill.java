package com.ssafy.project.db.entity.resume;

import com.ssafy.project.api.request.resume.SkillRequestDto;
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

    public Skill(Resume resume, SkillRequestDto requestDto){
        this.skillName = requestDto.getSkillName();
        this.skillLevel = requestDto.getSkillLevel();
        this.detail = requestDto.getDetail();
        this.resume = resume;
    }

    public void updateSkill(SkillRequestDto requestDto) {
        this.skillName = requestDto.getSkillName();
        this.skillLevel = requestDto.getSkillLevel();
        this.detail = requestDto.getDetail();
    }

}
