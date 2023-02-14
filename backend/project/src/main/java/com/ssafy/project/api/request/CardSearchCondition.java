package com.ssafy.project.api.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CardSearchCondition {
    private String skills;
    private String name;
    private String preferredJob;


}
