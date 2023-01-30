package com.ssafy.project.api.controller;

import com.ssafy.project.api.request.RecruitRequestDto;
import com.ssafy.project.api.service.RecruitService;
import com.ssafy.project.common.model.response.BaseResponseBody;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/recruit")
@RequiredArgsConstructor
public class RecruitController {

    private final RecruitService recruitService;

    @PostMapping("/{company_id}")
    public ResponseEntity<? extends BaseResponseBody> createRecruit(@PathVariable Long company_id,
                                                                    @RequestBody RecruitRequestDto requestDto) {

        recruitService.createRecruit(company_id, requestDto);

        return ResponseEntity.status(201).body(BaseResponseBody.of(201, "Success"));
    }

}
