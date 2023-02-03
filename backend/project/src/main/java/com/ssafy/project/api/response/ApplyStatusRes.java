package com.ssafy.project.api.response;

import com.ssafy.project.db.entity.ApplyStatus;
import com.ssafy.project.db.entity.Member;
import com.ssafy.project.db.entity.Recruit;
import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ApplyStatusRes {
    private String companyName;
    private String status;
    private String step;
    private String recruitTitle;

    public ApplyStatusRes(ApplyStatus applyStatus) {
        this.companyName = applyStatus.getRecruit().getCompany().getCompanyName();
        this.status = applyStatus.getStatus();
        this.step = applyStatus.getStep();
        this.recruitTitle = applyStatus.getRecruit().getRecruitTitle();
    }
}
