package com.example.planner.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
    @Table
    @NoArgsConstructor
    @AllArgsConstructor
    @Data
    public class Purchased {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        @OneToOne
        @JoinColumn(name = "quantity")
        private Quantity quantity;
        private double total;
        private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

        // Constructors, getters, setters, and other properties
    }
