package com.ssafy.project.api.controller;

import com.ssafy.project.api.request.CompanyRequestDto;
import com.ssafy.project.api.service.CompanyService;
import com.ssafy.project.common.model.response.BaseResponseBody;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/company")
@RequiredArgsConstructor
public class CompanyController {

    private final CompanyService companyService;

    @PostMapping("")
    public ResponseEntity<? extends BaseResponseBody> createCompany(@RequestBody CompanyRequestDto requestDto) {

        companyService.createCompany(requestDto);

        return ResponseEntity.status(201).body(BaseResponseBody.of(201, "Success"));
    }
}
