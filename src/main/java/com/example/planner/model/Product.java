package com.example.planner.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @Column(name = "product_type")
    private String productType;

    private double price;

    @Temporal(TemporalType.DATE)
    @Column(name = "in_date")
    private LocalDate inDate;

    private String image;
    @JsonIgnore
    @OneToMany(mappedBy = "product")
    private List<Purchased> purchases;
    @JsonIgnore
    @OneToOne(mappedBy = "product")
    private Quantity quantity;
}
