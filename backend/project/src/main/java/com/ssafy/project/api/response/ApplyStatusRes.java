package com.ssafy.project.api.response;

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


}
