package com.ssafy.project.api.controller;


import com.ssafy.project.api.request.ConferenceRequestDto;
import com.ssafy.project.api.response.BaseResponseBody;
import com.ssafy.project.api.response.ConferenceResponseDto;
import com.ssafy.project.api.service.ConferenceService;
import com.ssafy.project.common.auth.SsafyUserDetails;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/conference")
@RequiredArgsConstructor
public class ConferenceController {
    private static final Logger logger = LoggerFactory.getLogger(ConferenceController.class);
    private final ConferenceService conferenceService;

    @PostMapping("/{companyId}")
    public ResponseEntity<BaseResponseBody> CreateConference(@AuthenticationPrincipal SsafyUserDetails userDetails,
                                                             @RequestBody ConferenceRequestDto conReq,
                                                             @PathVariable Long companyId) {
        logger.info(conReq.getCallEndTime().toString());
        System.out.println(conReq.getMemberEmail());
        conferenceService.createConference(conReq, userDetails.getEmail(), companyId);
        return new ResponseEntity<>(new BaseResponseBody("Success", 200), HttpStatus.OK);
    }

    @GetMapping("/list/{type}")
    public ResponseEntity<?> getConferenceList(@AuthenticationPrincipal SsafyUserDetails userDetails,
                                               @PathVariable String type) {
        List<ConferenceResponseDto> list = conferenceService.getConferenceList(userDetails.getEmail(), type);
        return new ResponseEntity<List<ConferenceResponseDto>>(list, HttpStatus.OK);
    }

    @DeleteMapping("/{conferenceId}")
    public ResponseEntity<BaseResponseBody> deleteConference(@AuthenticationPrincipal SsafyUserDetails userDetails,
                                                             @PathVariable Long conferenceId){
        conferenceService.deleteConference(userDetails.getEmail(), conferenceId);
        return new ResponseEntity<>(new BaseResponseBody("Success", 200), HttpStatus.OK);
    }

    @PatchMapping("/{conferenceId}")
    public ResponseEntity<BaseResponseBody> updateConference(@PathVariable Long conferenceId,
                                                             @RequestBody ConferenceRequestDto conReq){
        conferenceService.updateConference(conReq,conferenceId);
        return new ResponseEntity<>(new BaseResponseBody("Success", 200), HttpStatus.OK);
    }

}

