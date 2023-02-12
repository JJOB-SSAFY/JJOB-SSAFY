package com.ssafy.project.api.controller;

import com.ssafy.project.api.response.MainResponseDto;
import com.ssafy.project.api.service.RecruitService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MainController {

    private final RecruitService recruitService;

    @GetMapping("/deadline")
    public ResponseEntity<List<MainResponseDto>> indexDeadline() {

        return new ResponseEntity<>(recruitService.getRecruitOrderByEndDate(), HttpStatus.OK);
    }

    @GetMapping("/latest")
    public ResponseEntity<List<MainResponseDto>> indexLatest() {

        return new ResponseEntity<>(recruitService.getRecruitOrderByStartDate(), HttpStatus.OK);
    }
}
