package com.example.planner.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;
@Table
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Purchased {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "product_code")
    private Product product;

    @OneToOne
    @JoinColumn(name = "quantity_id")
    private Quantity quantity;

    private int total;
    private LocalDate date;
}
