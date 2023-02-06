package com.ssafy.project.db.entity;

import com.ssafy.project.api.request.MyInfoRequestDto;
import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "card_id")
    private Long id;

    private String imageUrl;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String phone;

    private String github;

    private String blog;

    private String introduce;

    private String skills;

    private String preferredJob;

    @Column(columnDefinition="BOOLEAN DEFAULT false")
    private boolean visible;

    public static Card of(Member member, MyInfoRequestDto requestDto) {
        return Card.builder()
                .imageUrl(requestDto.getImageUrl())
                .name(member.getName())
                .email(member.getEmail())
                .phone(requestDto.getPhone())
                .github(requestDto.getGithub())
                .blog(requestDto.getBlog())
                .introduce(requestDto.getIntroduce())
                .skills(requestDto.getSkills())
                .preferredJob(requestDto.getPreferredJob())
                .build();
    }

    public void changeInfo(MyInfoRequestDto newInfo) {
        this.phone = newInfo.getPhone();
        this.blog = newInfo.getBlog();
        this.github = newInfo.getGithub();
        this.skills = newInfo.getSkills();
        this.preferredJob = newInfo.getPreferredJob();
        this.introduce = newInfo.getIntroduce();
        this.imageUrl = newInfo.getImageUrl();
        this.visible = newInfo.isVisible();
    }

}
