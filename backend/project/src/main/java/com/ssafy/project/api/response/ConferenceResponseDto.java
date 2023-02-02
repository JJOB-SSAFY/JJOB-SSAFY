package com.ssafy.project.api.response;

import com.ssafy.project.db.entity.Conference;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ConferenceResponseDto {

    private String title;
    private LocalDateTime callStartTime;
    private LocalDateTime callEndTime;
    private Long conferenceId;

    public ConferenceResponseDto(Conference conference) {
        this.title = conference.getConferenceTitle();
        this.callStartTime = conference.getCallStartTime();
        this.callEndTime = conference.getCallEndTime();
        this.conferenceId = conference.getId();
    }

}
