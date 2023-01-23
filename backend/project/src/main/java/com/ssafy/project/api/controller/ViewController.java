package com.ssafy.project.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    @GetMapping("/user/login")
    public String loginForm() {
        return "index";
    }
}
