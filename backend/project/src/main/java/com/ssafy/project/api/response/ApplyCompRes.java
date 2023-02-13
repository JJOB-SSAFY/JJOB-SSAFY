package com.ssafy.project.api.response;

import com.ssafy.project.db.entity.ApplyStatus;
import com.ssafy.project.db.entity.Card;
import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ApplyCompRes {

    private String companyName;
    private String status;
    private String step;
    private Long  resumeId;
    private String recruitTitle;
    private String resumeTitle;
    private String memberName;
    private String imageUrl;
    private String skills;

   public ApplyCompRes(ApplyStatus applyStatus, Card card){
       this.companyName = applyStatus.getRecruit().getCompany().getCompanyName();
       this.status = applyStatus.getStatus();
       this.step = applyStatus.getStep();
       this.recruitTitle = applyStatus.getRecruit().getRecruitTitle();
       this.resumeId = applyStatus.getResume().getId();
       this.resumeTitle = applyStatus.getResume().getResumeTitle();
       this.memberName = applyStatus.getMember().getName();
       this.imageUrl = card.getImageUrl();
       this. skills = card.getSkills();
   }
}
