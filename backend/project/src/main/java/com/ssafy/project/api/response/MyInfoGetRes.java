package com.ssafy.project.api.response;

import com.ssafy.project.db.entity.Card;
import com.ssafy.project.db.entity.Member;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class MyInfoGetRes {
    private String name;
    private String email;
    private String blog;
    private String phone;
    private String github;
    private String skills;
    private String preferredJob;
    private String introduce;
    private String imgUrl;

    public static MyInfoGetRes from(Member member) {
        return MyInfoGetRes.builder()
                .name(member.getName())
                .phone(member.getPhone())
                .email(member.getEmail())
                .build();
    }

    public static MyInfoGetRes from(Card card) {
        return MyInfoGetRes.builder()
                .name(card.getName())
                .phone(card.getPhone())
                .blog(card.getBlog())
                .email(card.getEmail())
                .github(card.getGithub())
                .introduce(card.getIntroduce())
                .skills(card.getSkills())
                .imgUrl(card.getImageUrl())
                .preferredJob(card.getPreferredJob())
                .build();
    }

}
