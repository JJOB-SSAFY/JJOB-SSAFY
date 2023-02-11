package com.ssafy.project.db.entity.resume;

import com.ssafy.project.api.request.resume.EducationRequestDto;
import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class Education {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "education_id")
    private Long id;

    @Column(nullable = false)
    private String educationName;

    @Column(nullable = false)
    private String educationPeriod;

    @Column(nullable = false)
    private String educationContent;

    @Column(nullable = false)
    private String educationInstitution;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "resume_id")
    private Resume resume;

    public Education(Resume resume, EducationRequestDto requestDto){
        this.resume = resume;
        this.educationName = requestDto.getEducationName();
        this.educationPeriod = requestDto.getEducationPeriod();
        this.educationContent = requestDto.getEducationContent();
        this.educationInstitution = requestDto.getEducationInstitution();
    }

    public void updateEducation(EducationRequestDto requestDto) {
        this.educationName = requestDto.getEducationName();
        this.educationPeriod = requestDto.getEducationPeriod();
        this.educationContent = requestDto.getEducationContent();
        this.educationInstitution = requestDto.getEducationInstitution();
    }

    public Education(Education education, Resume resume) {
        this.educationName = education.getEducationName();
        this.educationPeriod = education.getEducationPeriod();
        this.educationContent = education.getEducationContent();
        this.educationInstitution = education.getEducationInstitution();
        this.resume = resume;
    }

}
