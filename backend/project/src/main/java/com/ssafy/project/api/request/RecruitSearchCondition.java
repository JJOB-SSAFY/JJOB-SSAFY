package com.ssafy.project.api.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RecruitSearchCondition {

    private String location;
    private String department;
}
