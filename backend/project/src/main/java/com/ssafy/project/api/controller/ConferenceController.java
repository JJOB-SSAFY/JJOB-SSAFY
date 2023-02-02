package com.ssafy.project.api.controller;


import com.ssafy.project.api.request.ConferenceRequestDto;
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

    @PostMapping("")
    public ResponseEntity<?> CreateConference(@AuthenticationPrincipal SsafyUserDetails userDetails,
                                              @RequestBody ConferenceRequestDto conReq) {

        logger.info(conReq.getCallEndTime().toString());
        conferenceService.createConference(conReq, userDetails.getMember().getId());

        return new ResponseEntity<String>("Success", HttpStatus.OK);
    }

    @GetMapping("/list/{type}")
    public ResponseEntity<?> getConferenceList(@AuthenticationPrincipal SsafyUserDetails userDetails,
                                               @PathVariable String type) {

        List<ConferenceResponseDto> list = conferenceService.getConferenceList(userDetails.getMember().getId(),type);

        return new ResponseEntity<List<ConferenceResponseDto>>(list,HttpStatus.OK);
    }

    @DeleteMapping("/{conferenceId}")
    public ResponseEntity<?> deleteConference(@AuthenticationPrincipal SsafyUserDetails userDetails,
                                              @PathVariable Long conferenceId){

        conferenceService.deleteConference(userDetails.getMember().getId(), conferenceId);
        return new ResponseEntity<String>("Success", HttpStatus.OK);
    }

    @PatchMapping("/{conferenceId}")
    public ResponseEntity<?> updateConference(@PathVariable Long conferenceId,
                                              @RequestBody ConferenceRequestDto conReq){

        conferenceService.updateConference(conReq,conferenceId);
        return new ResponseEntity<String>("Success", HttpStatus.OK);
    }

}

