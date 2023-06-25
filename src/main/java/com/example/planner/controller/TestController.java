package com.example.planner.controller;

import com.example.planner.model.User;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class TestController {
    @GetMapping("")
    public String test() {
        return "hey there";
    }
}
