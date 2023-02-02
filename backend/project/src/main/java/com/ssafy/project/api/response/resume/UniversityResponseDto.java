package com.ssafy.project.api.response.resume;

import com.ssafy.project.db.entity.resume.University;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UniversityResponseDto {

    private String universityPeriod;

    private String universityName;

    private String major;

    public UniversityResponseDto(University university) {
        this.universityPeriod = university.getUniversityPeriod();
        this.universityName = university.getUniversityName();
        this.major = university.getMajor();
    }


}
