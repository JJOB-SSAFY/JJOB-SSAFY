package com.ssafy.project.api.service;


import com.ssafy.project.api.request.ConferenceRequestDto;
import com.ssafy.project.api.response.ConferenceListResDto;
import com.ssafy.project.common.exception.ApiException;
import com.ssafy.project.common.exception.ExceptionEnum;
import com.ssafy.project.db.entity.*;
import com.ssafy.project.db.repository.ConferenceRepository;
import com.ssafy.project.db.repository.MemberConferenceRepository;
import com.ssafy.project.db.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class ConferenceServiceImpl implements ConferenceService {

    private final MemberRepository memberRepository;
    private final MemberConferenceRepository memberConferenceRepository;
    private final ConferenceRepository conferenceRepository;

    @Override
    @Transactional
    public void createConference(ConferenceRequestDto requestDto, Long id) {

        Optional<Member> member = memberRepository.findById(id);
        if(!member.isPresent()){
            throw new ApiException(ExceptionEnum.MEMBER_NOT_EXIST_EXCEPTION);
        }
        Conference conference = Conference.builder().
                conferenceTitle(requestDto.getConferenceTitle()).
                callEndTime((requestDto.getCallEndTime())).
                callStartTime((requestDto.getCallStartTime())).
                conferenceCategory(ConferenceEnum.valueOf(requestDto.getConferenceCategory())).
                member(member.get()).
                build();
        conferenceRepository.save(conference);
        List<Map<String,String>> emailList= requestDto.getMemberEmail();

        // 면접대상 이메일로 조회
        for (Map<String, String> stringStringMap : emailList) {
            String email=stringStringMap.get("email");
            Optional<Member> memberEmail = memberRepository.findByEmail(email);
            if(!memberEmail.isPresent()){
                throw new ApiException(ExceptionEnum.MEMBER_NOT_EXIST_EXCEPTION);
            }
            MemberConference memberConference = MemberConference.builder().
                    member(memberEmail.get()).
                    conference(conference).build();

            memberConferenceRepository.save(memberConference);

        }

    }

    @Override
    @Transactional
    public List<ConferenceListResDto> getConferenceList(Long memberId,String type) {
        List<MemberConference> conference = memberConferenceRepository.findAllByMemberId(memberId);
        List<ConferenceListResDto> conferenceList = new ArrayList<>();

        for (MemberConference memberConference : conference) {

            if(memberConference.getConference().getConferenceCategory()==ConferenceEnum.valueOf(type)) {

                ConferenceListResDto conList = ConferenceListResDto.builder().
                        title(memberConference.getConference().getConferenceTitle()).
                        callStartTime(memberConference.getConference().getCallStartTime()).
                        conferenceId(memberConference.getConference().getId()).build();

                conferenceList.add(conList);
            }
        }
        return conferenceList;
    }

    @Override
    @Transactional
    public void deleteConference(Long id) {
        memberConferenceRepository.deleteAllByConferenceId(id);
        conferenceRepository.deleteAllById(id);
    }

    @Override
    @Transactional
    public void updateConference(ConferenceRequestDto requestDto, Long id) {
        Optional<Conference> conference = conferenceRepository.findById(id);
        if(!conference.isPresent()){ // 오류 수정
            throw new ApiException(ExceptionEnum.MEMBER_NOT_EXIST_EXCEPTION);
        }
            Conference conferenceUpdate = Conference.builder().
                conferenceTitle(requestDto.getConferenceTitle()).
                conferenceCategory(ConferenceEnum.valueOf(requestDto.getConferenceCategory())).
                callStartTime(requestDto.getCallStartTime()).
                callEndTime((requestDto.getCallEndTime())).
                build();

            conference.get().changeConference(conferenceUpdate);


    }


}
