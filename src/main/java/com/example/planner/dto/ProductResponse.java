package com.example.planner.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponse {
    private Long code;
    private String name;
    private double price;
    private String productType;
    private int quantity;
    private LocalDate inDate;
}
