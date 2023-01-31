package com.ssafy.project.db.entity;

import com.ssafy.project.api.request.CompanyRequestDto;
import com.ssafy.project.api.request.RecruitRequestDto;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class Recruit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "recruit_id")
    private Long id;

    private String recruitTitle;

    private String eduRequirement;

    private String workType;

    private String career;

    private String salary;

    private String location;

    private String imgUrl;

    private String recruitContent;

    private LocalDate recruitStartDate;

    private LocalDate recruitEndDate;

    private String department;

    private String work;

    private String requirement;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    private Company company;

    public static Recruit of(RecruitRequestDto requestDto, Company company, Member member) {
        return Recruit.builder()
                .recruitTitle(requestDto.getRecruitTitle())
                .eduRequirement(requestDto.getEduRequirement())
                .workType(requestDto.getWorkType())
                .career(requestDto.getCareer())
                .salary(requestDto.getSalary())
                .location(requestDto.getLocation())
                .imgUrl(requestDto.getImgUrl())
                .recruitContent(requestDto.getRecruitContent())
                .recruitStartDate(requestDto.getRecruitStartDate())
                .recruitEndDate(requestDto.getRecruitEndDate())
                .department(requestDto.getDepartment())
                .work(requestDto.getWork())
                .requirement(requestDto.getRequirement())
                .member(member)
                .company(company)
                .build();
    }

    public void updateRecruit(RecruitRequestDto requestDto) {
        this.recruitTitle = requestDto.getRecruitTitle();
        this.eduRequirement = requestDto.getEduRequirement();
        this.workType = requestDto.getWorkType();
        this.career = requestDto.getCareer();
        this.salary = requestDto.getSalary();
        this.location = requestDto.getLocation();
        this.imgUrl = requestDto.getImgUrl();
        this.recruitContent = requestDto.getRecruitContent();
        this.recruitStartDate = requestDto.getRecruitStartDate();
        this.recruitEndDate = requestDto.getRecruitEndDate();
        this.department = requestDto.getDepartment();
        this.work = requestDto.getWork();
        this.requirement = requestDto.getRequirement();
    }

}
