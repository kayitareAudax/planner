package com.example.planner.controller;

import com.example.planner.dto.AuthResponse;
import com.example.planner.dto.QuantityDTO;
import com.example.planner.dto.QuantityResponse;
import com.example.planner.service.QuantityService;
import jakarta.validation.Valid;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/products/{productId}/quantity")
public class QuantityController {

    private final QuantityService quantityService;

    public QuantityController(QuantityService quantityService) {
        this.quantityService = quantityService;
    }

    @PostMapping
    public ResponseEntity<QuantityResponse> addQuantityToProduct(
            @PathVariable Long productId,
            @Valid @RequestBody QuantityDTO quantityDTO,
            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            bindingResult.getFieldErrors().forEach(error ->
                    errors.put(error.getField(), error.getDefaultMessage()));
            if(!errors.isEmpty()){
                String error=errors.values().iterator().next();
                AuthResponse authResponse=AuthResponse.builder().success(false).message(error).build();
                var quantityResp= QuantityResponse.builder().success(false).message(error).build();
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(quantityResp);
            }
        }
//        quantityService.addQuantityToProduct(productId, quantityDTO);
        return ResponseEntity.ok(quantityService.addQuantityToProduct(productId,quantityDTO));
    }
}
