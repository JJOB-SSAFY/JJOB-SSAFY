package com.ssafy.project.db.entity.resume;

import com.ssafy.project.api.request.resume.UniversityRequestDto;
import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class University {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "university_id")
    private Long id;

    private String universityPeriod;

    private String universityName;

    private String major;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "resume_id")
    private Resume resume;

    public University(Resume resume, UniversityRequestDto requestDto) {
        this.resume = resume;
        this.universityPeriod = requestDto.getUniversityPeriod();
        this.universityName = requestDto.getUniversityName();
        this.major = requestDto.getMajor();
    }

    public void updateUniversity(UniversityRequestDto requestDto) {
        this.universityPeriod = requestDto.getUniversityPeriod();
        this.universityName = requestDto.getUniversityName();
        this.major = requestDto.getMajor();
    }

    public University(University university, Resume resume) {
        this.universityPeriod = university.getUniversityPeriod();
        this.universityName = university.getUniversityName();
        this.major = university.getMajor();
        this.resume = resume;
    }
}
