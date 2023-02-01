package com.ssafy.project.api.service;


import com.ssafy.project.api.request.ConferenceRequestDto;
import com.ssafy.project.api.response.ConferenceListResDto;

import java.util.List;

public interface ConferenceService {

    void createConference(ConferenceRequestDto requestDto,Long id);
    List<ConferenceListResDto> getConferenceList(Long id,String type);
    void deleteConference(Long id);

    void updateConference(ConferenceRequestDto requestDto,Long id);

}
