package com.ssafy.project.api.response;

import com.ssafy.project.db.entity.Card;
import com.ssafy.project.db.entity.Company;
import com.ssafy.project.db.entity.Recruit;
import lombok.*;

import javax.persistence.Column;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CardResponseDto {

    private Long id;

    private String imageUrl;

    private String name;

    private String email;

    private String phone;

    private String github;

    private String blog;

    private String introduce;

    private String skills;

    private String preferredJob;

    public CardResponseDto(Card card) {
       this.preferredJob = card.getPreferredJob();
       this.skills = card.getSkills();
       this.introduce = card.getIntroduce();
       this.blog = card.getBlog();
       this.github = card.getGithub();
       this.phone = card.getPhone();
       this.email = card.getEmail();
       this.name= card.getName();
       this.imageUrl = card.getImageUrl();
       this.id = card.getId();

    }

}
