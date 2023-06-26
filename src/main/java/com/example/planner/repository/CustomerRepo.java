package com.example.planner.repository;

import com.example.planner.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface CustomerRepo extends JpaRepository<Customer,UUID> {
    public Customer findUserByEmail(String email);
}
