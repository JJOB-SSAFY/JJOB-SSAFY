package com.ssafy.project.db.entity.resume;

import com.ssafy.project.db.entity.Company;
import com.ssafy.project.db.entity.Member;
import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class Resume {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "resume_id")
    private Long id;

    @Column(nullable = false)
    private String name;

    private String blog;

    private String phone;

    private String portfolio;

    private String email;

    private String github;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    private Company company;

}
