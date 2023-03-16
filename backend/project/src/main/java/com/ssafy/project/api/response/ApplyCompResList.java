package com.ssafy.project.api.response;

import com.ssafy.project.db.entity.ApplyStatus;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ApplyCompResList {

    @Builder.Default
    private List<ApplyCompRes> applyCompResList = new ArrayList<>();

    public static ApplyCompResList of(List<ApplyCompRes> applyCompResList){
        return ApplyCompResList.builder()
                .applyCompResList(applyCompResList)
                .build();
    }



}
