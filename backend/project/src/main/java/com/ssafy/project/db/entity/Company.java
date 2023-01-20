package com.ssafy.project.db.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "company_id")
    private Long id;

    @Column(nullable = false, unique = true)
    private String companyName;

    @Column(nullable = false)
    private String companyUrl;

    @Column(nullable = false)
    private String companyAddress;

    @Column(nullable = false)
    private int employeeCnt;

    @Column(nullable = false)
    private String companyDesc;

}
