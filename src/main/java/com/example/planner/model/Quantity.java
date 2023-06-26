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

    @OneToOne
    @JoinColumn(name = "product_id") // Specify the foreign key column
    private Product product;
    private int quantity;

    private String operation;
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @PrePersist
    public void prePersist() {
        if (date == null) {
            date = new Date();
        }
    }
}
