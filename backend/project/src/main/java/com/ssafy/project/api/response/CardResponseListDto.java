package com.ssafy.project.api.response;

import com.querydsl.core.annotations.QueryProjection;
import com.ssafy.project.db.entity.Card;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CardResponseListDto {

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

    @QueryProjection
    public CardResponseListDto(String preferredJob, String skills, String introduce, String blog,
                               String github, String phone, String email, String name, String imageUrl, Long id) {
        this.preferredJob = preferredJob;
        this.skills = skills;
        this.introduce = introduce;
        this.blog = blog;
        this.github = github;
        this.phone = phone;
        this.email = email;
        this.name= name;
        this.imageUrl = imageUrl;
        this.id = id;

    }


    //@QueryProjection
    //    public RecruitResponseListDto(Long recruitId, String recruitTitle, String department, String workType,
    //                                  String work, String requirement, LocalDate recruitEndDate, String companyName,
    //                                  String location, LocalDate recruitStartDate,String recruitImage) {
    //        this.recruitId = recruitId;
    //        this.recruitTitle = recruitTitle;
    //        this.department = department;
    //        this.workType = workType;
    //        this.work = work;
    //        this.requirement = requirement;
    //        this.recruitEndDate = recruitEndDate;
    //        this.companyName = companyName;
    //        this.location = location;
    //        this.recruitStartDate = recruitStartDate;
    //        this.recruitImage = recruitImage;
    //    }


}
