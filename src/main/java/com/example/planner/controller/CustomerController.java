package com.example.planner.controller;

import com.example.planner.dto.AuthResponse;
import com.example.planner.dto.LoginRequest;
import com.example.planner.dto.RegisterRequest;
import com.example.planner.service.CustomerService;
import jakarta.validation.Valid;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Data
@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
@CrossOrigin()
public class CustomerController {
    private final CustomerService userService;

    @PostMapping("/signup")
    public ResponseEntity<AuthResponse> register(@Valid @RequestBody RegisterRequest request, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            bindingResult.getFieldErrors().forEach(error ->
                    errors.put(error.getField(), error.getDefaultMessage()));
            if(!errors.isEmpty()){
                String error=errors.values().iterator().next();
                AuthResponse authResponse=AuthResponse.builder().success(false).message(error).build();
                return ResponseEntity.badRequest().body(authResponse);
            }
        }
        return ResponseEntity.ok(userService.registerUser(request));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request) {
        return ResponseEntity.ok(userService.loginUser(request));
    }
}
