package com.ssafy.project.api.response;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ConferenceListResDto {

    private String title;
    private LocalDateTime callStartTime;
    private Long conferenceId;

}
