package com.ssafy.project.db.entity.resume;

import com.ssafy.project.api.request.resume.ResumeRequestDto;
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
    private String resumeTitle;

    @Column(nullable = false)
    private String subTitle;

    private String introduce;

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

    public static Resume of(Member member, ResumeRequestDto requestDto) {
        return Resume.builder()
                .member(member)
                .resumeTitle(requestDto.getResumeTitle())
                .subTitle(requestDto.getSubTitle())
                .introduce(requestDto.getIntroduce())
                .name(requestDto.getName())
                .blog(requestDto.getBlog())
                .phone(requestDto.getPhone())
                .portfolio(requestDto.getPortfolio())
                .email(requestDto.getEmail())
                .github(requestDto.getGithub())
                .build();
    }

    public void updateResume(ResumeRequestDto requestDto){
        this.resumeTitle = requestDto.getResumeTitle();
        this.subTitle = requestDto.getSubTitle();
        this.introduce = requestDto.getIntroduce();
        this.name = requestDto.getName();
        this.blog = requestDto.getBlog();
        this.phone = requestDto.getPhone();
        this.portfolio = requestDto.getPortfolio();
        this.email = requestDto.getEmail();
        this.github = requestDto.getGithub();
    }

}
