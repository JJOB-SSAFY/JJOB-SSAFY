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
    private String name;

    private String blog;

    private String phone;

    private String portfolio;

    private String email;

    private Boolean isOpened;

    private Boolean isApplied;

    private String github;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    public static Resume of(Member member, ResumeRequestDto requestDto) {
        return Resume.builder()
                .member(member)
                .resumeTitle(requestDto.getResumeTitle())
                .name(requestDto.getName())
                .blog(requestDto.getBlog())
                .phone(requestDto.getPhone())
                .portfolio(requestDto.getPortfolio())
                .email(requestDto.getEmail())
                .github(requestDto.getGithub())
                .isOpened(false)
                .isApplied(false)
                .build();
    }

    public void updateResume(ResumeRequestDto requestDto){
        this.resumeTitle = requestDto.getResumeTitle();
        this.name = requestDto.getName();
        this.blog = requestDto.getBlog();
        this.phone = requestDto.getPhone();
        this.portfolio = requestDto.getPortfolio();
        this.email = requestDto.getEmail();
        this.github = requestDto.getGithub();
        this.isApplied = requestDto.getIsApplied();
    }

    public void updateStatus() {
        this.isOpened = true;
    }

    public Resume(Resume resume) {
        this.resumeTitle = resume.getResumeTitle();
        this.name = resume.getName();
        this.blog = resume.getBlog();
        this.phone = resume.getPhone();
        this.portfolio = resume.getPortfolio();
        this.email = resume.getEmail();
        this.github = resume.getGithub();
        this.isOpened = false;
        this.isApplied = true;
        this.member = resume.getMember();
    }

}
