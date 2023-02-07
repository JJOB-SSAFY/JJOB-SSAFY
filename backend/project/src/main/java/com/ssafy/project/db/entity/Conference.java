package com.ssafy.project.db.entity;

import com.ssafy.project.api.request.ConferenceRequestDto;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class Conference {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "conference_id")
    private Long id;

    @Column(nullable = false)
    private String conferenceTitle;

    @Column(nullable = false)
    private LocalDateTime callEndTime;

    @Column(nullable = false)
    private LocalDateTime callStartTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    private Company company;

    @Enumerated(EnumType.STRING)
    private ConferenceEnum conferenceCategory;

    public static Conference of(ConferenceRequestDto requestDto, Member member, Company company) {
        return Conference.builder()
                .conferenceTitle(requestDto.getConferenceTitle())
                .callStartTime(requestDto.getCallStartTime())
                .callEndTime(requestDto.getCallEndTime())
                .conferenceCategory(ConferenceEnum.valueOf(requestDto.getConferenceCategory()))
                .member(member)
                .company(company)
                .build();
    }

    public void changeConference(Conference conference){
        this.conferenceCategory = conference.getConferenceCategory();
        this.callEndTime = conference.callEndTime;
        this.callStartTime = conference.callStartTime;
        this.conferenceTitle = conference.getConferenceTitle();
    }

}
