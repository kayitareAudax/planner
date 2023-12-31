package com.example.planner.repository;

import com.example.planner.model.Product;
import com.example.planner.model.Quantity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuantityRepo extends JpaRepository<Quantity,Long> {
    Quantity findQuantityByProduct(Product product);
}
