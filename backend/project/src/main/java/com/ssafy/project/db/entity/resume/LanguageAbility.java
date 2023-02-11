package com.ssafy.project.db.entity.resume;

import com.ssafy.project.api.request.resume.LanguageAbilityRequestDto;
import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class LanguageAbility {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "language_ability_id")
    private Long id;

    @Column(nullable = false)
    private String language;

    @Column(nullable = false)
    private String testName;

    @Column(nullable = false)
    private String grade;

    @Column(nullable = false)
    private String testDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "resume_id")
    private Resume resume;

    public LanguageAbility(Resume resume, LanguageAbilityRequestDto requestDto){
        this.resume = resume;
        this.language = requestDto.getLanguage();
        this.testName = requestDto.getTestName();
        this.grade = requestDto.getGrade();
        this.testDate = requestDto.getTestDate();
    }

    public void updateLanguageAbility(LanguageAbilityRequestDto requestDto) {
        this.language = requestDto.getLanguage();
        this.testName = requestDto.getTestName();
        this.grade = requestDto.getGrade();
        this.testDate = requestDto.getTestDate();
    }

    public LanguageAbility(LanguageAbility languageAbility, Resume resume) {
        this.language = languageAbility.getLanguage();
        this.testName = languageAbility.getTestName();
        this.grade = languageAbility.getGrade();
        this.testDate = languageAbility.getTestDate();
        this.resume = resume;
    }

}
