package com.example.planner.service;

import com.example.planner.model.Product;
import com.example.planner.model.Purchased;
import com.example.planner.model.Quantity;
import com.example.planner.repository.ProductRepo;
import com.example.planner.repository.PurchasedRepo;
import com.example.planner.repository.QuantityRepo;
import com.example.planner.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class PurchaseService {

    private final ProductService productService;
    private final PurchasedRepo purchasedRepository;
    private final ProductRepo productRepo;
    private final QuantityRepo quantityRepo;
    public void createPurchase(Long productCode, int quantity, LocalDate date) {
        Product product = productRepo.findById(productCode).get();
        Quantity quantity1=quantityRepo.findQuantityByProduct(product);
        if (product == null) {
            throw new IllegalArgumentException("Product with code " + productCode + " does not exist");
        }

        Purchased purchased = new Purchased();
        purchased.setProduct(product);
        purchased.setQuantity(quantity1);
        purchased.setDate(date);
        purchased.setTotal(product.getPrice() * quantity);
        purchasedRepository.save(purchased);
    }
}
