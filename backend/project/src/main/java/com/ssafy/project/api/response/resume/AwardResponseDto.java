package com.ssafy.project.api.response.resume;

import com.ssafy.project.db.entity.resume.Award;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class AwardResponseDto {

    private String awardName;

    private String awardDate;

    private String awardInstitution;

    public AwardResponseDto(Award award) {
        this.awardName = award.getAwardName();
        this.awardDate = award.getAwardDate();
        this.awardInstitution = award.getAwardInstitution();

    }

}
