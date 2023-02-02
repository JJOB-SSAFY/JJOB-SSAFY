package com.ssafy.project.api.service;


import com.ssafy.project.api.request.ConferenceRequestDto;
import com.ssafy.project.api.response.ConferenceResponseDto;

import java.util.List;

public interface ConferenceService {

    void createConference(ConferenceRequestDto requestDto,Long id);
    List<ConferenceResponseDto> getConferenceList(Long id, String type);
    void deleteConference(Long memberId, Long conferenceId);

    void updateConference(ConferenceRequestDto requestDto,Long id);

}
