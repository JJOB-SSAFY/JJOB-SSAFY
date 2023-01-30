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

    @GetMapping("")
    public ResponseEntity<List<MainResponseDto>> index() {

        return new ResponseEntity<>(recruitService.getRecruitOrderByDate(), HttpStatus.OK);
    }

}
