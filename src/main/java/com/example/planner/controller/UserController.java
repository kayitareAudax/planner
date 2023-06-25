package com.example.planner.controller;

import com.example.planner.dto.AuthResponse;
import com.example.planner.dto.LoginRequest;
import com.example.planner.dto.RegisterRequest;
import com.example.planner.service.UserService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Data
@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
@CrossOrigin()
public class UserController {
    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(userService.registerUser(request));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request) {
        return ResponseEntity.ok(userService.loginUser(request));
    }
}
