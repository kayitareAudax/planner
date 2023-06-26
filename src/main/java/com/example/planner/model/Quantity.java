package com.example.planner.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Quantity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int quantity;
    private String operation;
    private LocalDate date;

    @OneToOne(mappedBy = "quantity")
    private Purchased purchased;

    @OneToMany(mappedBy = "quantity")
    private List<Product> products;
}
