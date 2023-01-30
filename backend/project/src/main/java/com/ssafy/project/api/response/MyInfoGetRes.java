package com.ssafy.project.api.response;

import com.ssafy.project.common.model.response.BaseResponseBody;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class MyInfoGetRes extends BaseResponseBody {
    private String name;
    private String email;
    private String blog;
    private String phone;
    private String github;
    private String skills;
    private String preferredJob;
    private String introduce;
    private String imgUrl;

}
