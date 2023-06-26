package com.example.planner.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class QuantityDTO {
    @NotNull(message = "Quantity is required")
    @Min(value = 1, message = "Quantity must be a positive number")
    private Integer quantity;

    @NotBlank(message = "Operation is required")
    private String operation;

    @NotNull(message = "Date is required")
    @JsonFormat(pattern = "dd-MM-yyyy")
    @PastOrPresent(message = "Date must be in the past or present")
    private LocalDate date;
}
