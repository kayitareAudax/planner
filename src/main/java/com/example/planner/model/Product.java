package com.example.planner.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.UUID;
@Table
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long code;
    private String name;
    private String productType;
    private double price;
    private LocalDate inDate;
    @ManyToOne
    @JoinColumn(name = "quantity_id")
    private Quantity quantity;

    @OneToOne(mappedBy = "product")
    private Purchased purchased;
}
