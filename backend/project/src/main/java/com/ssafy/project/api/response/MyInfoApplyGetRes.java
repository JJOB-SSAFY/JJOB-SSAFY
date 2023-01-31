package com.ssafy.project.api.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class MyInfoApplyGetRes {
    private String companyName;
    private String status;
    private String step;
    private String recruitTitle;

//    @QueryProjection
//    public applyStatusGetRes(String companyName, String status, String step,
//                                  String recruitTitle) {
//        this.companyName = companyName;
//        this.status = status;
//        this.step = step;
//        this.recruitTitle = recruitTitle;
//    }

}
