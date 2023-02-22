package com.ssafy.project.api.service;


import com.ssafy.project.api.request.ConferenceRequestDto;
import com.ssafy.project.api.response.ConferenceResponseDto;

import java.util.List;

public interface ConferenceService {

    Long createConference(ConferenceRequestDto requestDto,String email, Long companyId);
    List<ConferenceResponseDto> getConferenceList(String email, String type);
    void deleteConference(String email, Long conferenceId);

    void updateConference(ConferenceRequestDto requestDto,Long id);

}
