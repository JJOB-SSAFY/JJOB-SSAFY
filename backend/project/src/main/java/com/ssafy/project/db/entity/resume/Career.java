package com.ssafy.project.db.entity.resume;

import com.ssafy.project.api.request.resume.CareerRequestDto;
import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class Career {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "career_id")
    private Long id;

    @Column(nullable = false)
    private String companyName;

    @Column(nullable = false)
    private String careerPeriod;

    @Column(nullable = false)
    private String careerContent;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "resume_id")
    private Resume resume;

    public Career(Resume resume, CareerRequestDto requestDto){
        this.resume = resume;
        this.companyName = requestDto.getCompanyName();
        this.careerPeriod = requestDto.getCareerPeriod();
        this.careerContent = requestDto.getCareerContent();
    }

    public void updateCareer(CareerRequestDto requestDto){
        this.companyName = requestDto.getCompanyName();
        this.careerPeriod = requestDto.getCareerPeriod();
        this.careerContent = requestDto.getCareerContent();
    }

    public Career(Career career, Resume resume) {
        this.companyName = career.getCompanyName();
        this.careerPeriod = career.getCareerPeriod();
        this.careerContent = career.getCareerContent();
        this.resume = resume;
    }

}
