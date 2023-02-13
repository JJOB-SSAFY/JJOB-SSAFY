package com.ssafy.project.db.entity;

import com.ssafy.project.api.request.ApplyFailRequestDto;
import com.ssafy.project.api.request.ApplyRequestDto;
import com.ssafy.project.api.response.ApplyStatusRes;
import com.ssafy.project.db.entity.resume.Resume;
import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@ToString
public class ApplyStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "apply_status_id")
    private Long id;

    @Column(nullable = false)
    private String step;

    @Column(nullable = false)
    private String status;

    private String reason;

    private String feedback;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="recruit_id")
    private Recruit recruit;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "resume_id")
    private Resume resume;

    public static ApplyStatus of(Member member, Recruit recruit, ApplyRequestDto requestDto, Resume resume){
        return ApplyStatus.builder()
                .member(member)
                .recruit(recruit)
                .step(requestDto.getStep())
                .status(requestDto.getStatus())
                .resume(resume)
                .build();
    }

    public void updateApplyStatus(ApplyRequestDto requestDto) {
        this.status = requestDto.getStatus();
        this.step = requestDto.getStep();
    }

    public void updateReason(ApplyFailRequestDto requestDto) {
        this.reason = requestDto.getReason();
        this.feedback = requestDto.getFeedback();
    }

}
