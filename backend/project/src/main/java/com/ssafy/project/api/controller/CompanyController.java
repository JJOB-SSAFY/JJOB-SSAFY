package com.ssafy.project.api.controller;

import com.ssafy.project.api.request.CompanyRequestDto;
import com.ssafy.project.api.response.CompanyResponseDto;
import com.ssafy.project.api.service.CompanyService;
import com.ssafy.project.api.response.BaseResponseBody;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/company")
@RequiredArgsConstructor
public class CompanyController {

    private final CompanyService companyService;

    @PostMapping("")
    public ResponseEntity<? extends BaseResponseBody> createCompany(@RequestBody CompanyRequestDto requestDto) {

        companyService.createCompany(requestDto);

        return new ResponseEntity<>(new BaseResponseBody("Success", 201), HttpStatus.CREATED);
    }

    @PatchMapping("/{company_id}")
    public ResponseEntity<CompanyResponseDto> updateCompany(@PathVariable Long company_id , @RequestBody CompanyRequestDto requestDto){
        return new ResponseEntity<>(companyService.updateCompany(company_id, requestDto), HttpStatus.OK);

    }

    @DeleteMapping("/{company_id}")
    public ResponseEntity<? extends BaseResponseBody> deleteCompany(@PathVariable Long company_id){
        companyService.deleteCompany(company_id);
        return new ResponseEntity<>(new BaseResponseBody("Success", 200), HttpStatus.OK);
    }

}
