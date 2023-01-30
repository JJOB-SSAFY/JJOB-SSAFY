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

    @OneToMany(mappedBy = "recruit", cascade = CascadeType.REMOVE)
    private List<MemberRecruit> memberRecruits = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    private Company company;

    public static Recruit of(RecruitRequestDto requestDto, Company company) {
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
                .company(company)
                .build();
    }

}
