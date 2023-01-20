package com.ssafy.project.db.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

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

    private LocalDateTime recruitDate;

    private String department;

    private String work;

    private String requirement;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    private Company company;

}
