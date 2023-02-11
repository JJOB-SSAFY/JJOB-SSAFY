package com.ssafy.project.db.entity.resume;

import com.ssafy.project.api.request.resume.AwardRequestDto;
import lombok.*;

import javax.persistence.*;

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

    private String awardName;

    private String awardDate;

    private String awardInstitution;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "resume_id")
    private Resume resume;

    public Award(Resume resume, AwardRequestDto requestDto){
        this.resume = resume;
        this.awardName = requestDto.getAwardName();
        this.awardDate = requestDto.getAwardDate();
        this.awardInstitution = requestDto.getAwardInstitution();
    }

    public void updateAward(AwardRequestDto requestDto){
        this.awardName = requestDto.getAwardName();
        this.awardDate = requestDto.getAwardDate();
        this.awardInstitution = requestDto.getAwardInstitution();
    }

    public Award(Award award, Resume resume) {
        this.awardName = award.getAwardName();
        this.awardDate = award.getAwardDate();
        this.awardInstitution = award.getAwardInstitution();
        this.resume = resume;
    }

}
