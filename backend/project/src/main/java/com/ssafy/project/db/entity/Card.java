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
    public void changeInfo(MyInfoRequestDto newInfo) {
        this.phone = newInfo.getPhone();
        this.blog = newInfo.getBlog();
        this.github = newInfo.getGithub();
        this.skills = newInfo.getSkills();
        this.preferredJob = newInfo.getPreferredJob();
        this.introduce = newInfo.getIntroduce();
        this.imageUrl = newInfo.getImageUrl();
    }

}
