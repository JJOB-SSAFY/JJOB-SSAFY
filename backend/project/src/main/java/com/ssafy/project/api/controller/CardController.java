package com.ssafy.project.api.controller;


import com.ssafy.project.api.request.CardSearchCondition;
import com.ssafy.project.api.response.CardResponseDto;
import com.ssafy.project.api.response.CardResponseListDto;
import com.ssafy.project.api.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/card")
@RequiredArgsConstructor
public class CardController {

    private final CardService cardService;

    @GetMapping("")
    public ResponseEntity<?> getCard(){
        List<CardResponseDto> cardList = cardList=cardService.getCard();
        return new ResponseEntity<List<CardResponseDto>>(cardList, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<List<CardResponseListDto>> getCardList(@RequestBody CardSearchCondition condition){
        return new ResponseEntity<>(cardService.getCardList(condition), HttpStatus.OK);
    }


}