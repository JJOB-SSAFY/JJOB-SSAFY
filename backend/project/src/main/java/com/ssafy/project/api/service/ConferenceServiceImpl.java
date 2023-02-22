package com.ssafy.project.api.service;


import com.ssafy.project.api.request.ConferenceRequestDto;
import com.ssafy.project.api.response.ConferenceResponseDto;
import com.ssafy.project.common.exception.ApiException;
import com.ssafy.project.common.exception.ExceptionEnum;
import com.ssafy.project.db.entity.*;
import com.ssafy.project.db.repository.CompanyRepository;
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
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@Service("conferenceService")
@RequiredArgsConstructor
@Slf4j
public class ConferenceServiceImpl implements ConferenceService {

    private final MemberRepository memberRepository;
    private final MemberConferenceRepository memberConferenceRepository;
    private final ConferenceRepository conferenceRepository;
    private final CompanyRepository companyRepository;

    @Override
    @Transactional
    public void createConference(ConferenceRequestDto requestDto, String email, Long companyId) {

        Member member = memberRepository.findByEmail(email)
                .orElseThrow(() -> new ApiException(ExceptionEnum.MEMBER_NOT_EXIST_EXCEPTION));

        Company company = companyRepository.findById(companyId)
                .orElseThrow(() -> new ApiException(ExceptionEnum.COMPANY_NOT_EXIST_EXCEPTION));

        Conference conference = Conference.of(requestDto, member, company);

        conferenceRepository.save(conference);

        List<String> emailList = requestDto.getMemberEmail();

        // 면접대상 이메일로 조회
        saveInterviewParticipant(emailList, conference);

    }

    private void saveInterviewParticipant(List<String> emailList, Conference conference) {
        for (String email : emailList) {
            Member member = memberRepository.findByEmail(email)
                    .orElseThrow(() -> new ApiException(ExceptionEnum.MEMBER_NOT_EXIST_EXCEPTION));

            MemberConference memberConference = MemberConference.builder()
                    .member(member)
                    .conference(conference)
                    .build();

            memberConferenceRepository.save(memberConference);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<ConferenceResponseDto> getConferenceList(String email, String type) {
        List<MemberConference> memberConferenceList = memberConferenceRepository
                .findAllByMemberEmailAndConference_conferenceCategoryOrderByConference_callStartTimeDesc(email, ConferenceEnum.valueOf(type));

        return memberConferenceList.stream().map((o) -> new ConferenceResponseDto(o.getConference())).collect(toList());
    }

    @Override
    @Transactional
    public void deleteConference(String email, Long conferenceId) {

        Member member = memberRepository.findByEmail(email)
                .orElseThrow(() -> new ApiException(ExceptionEnum.MEMBER_NOT_EXIST_EXCEPTION));

        Conference conference = conferenceRepository.findById(conferenceId)
                .orElseThrow(() -> new ApiException(ExceptionEnum.CONFERENCE_NOT_EXIST_EXCEPTION));

        if (!member.getId().equals(conference.getMember().getId())) throw new ApiException(ExceptionEnum.MEMBER_ACCESS_EXCEPTION);

        memberConferenceRepository.deleteAllByConferenceId(conferenceId);
        conferenceRepository.deleteAllById(conferenceId);
    }

    @Override
    @Transactional
    public void updateConference(ConferenceRequestDto requestDto, Long id) {
//        Optional<Conference> conference = conferenceRepository.findById(id);
//        if(conference.isEmpty()){ // 오류 수정
//            throw new ApiException(ExceptionEnum.CONFERENCE_NOT_EXIST_EXCEPTION);
//        }
//            Conference conferenceUpdate = Conference.builder().
//                conferenceTitle(requestDto.getConferenceTitle()).
//                conferenceCategory(ConferenceEnum.valueOf(requestDto.getConferenceCategory())).
//                callStartTime(requestDto.getCallStartTime()).
//                callEndTime((requestDto.getCallEndTime())).
//                build();
//
//            conference.get().changeConference(conferenceUpdate);

    }

}
