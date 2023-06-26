package com.example.planner.service;

import com.example.planner.dto.QuantityDTO;
import com.example.planner.dto.QuantityResponse;
import com.example.planner.model.Product;
import com.example.planner.model.Quantity;
import com.example.planner.repository.ProductRepo;
import com.example.planner.repository.QuantityRepo;
import com.example.planner.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class QuantityService {

    private final ProductService productService;
    private final QuantityRepo quantityRepo;
    private final ProductRepo productRepo;
    public QuantityResponse addQuantityToProduct(Long productId, QuantityDTO quantityDTO) {
        // Retrieve the product by ID
        Optional<Product> product = Optional.ofNullable(productRepo.findById(productId)
                .orElseThrow(() -> new IllegalArgumentException("Product not found with ID: " + productId)));
        //check if the quantity is negative or zero
        if (quantityDTO.getQuantity() <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than zero");
        }
        // Create the Quantity entity
        Quantity quantity = new Quantity();
        quantity.setProduct(product.get());
        quantity.setQuantity(quantityDTO.getQuantity());
        quantity.setOperation(quantityDTO.getOperation());
        quantityRepo.save(quantity);
        product.get().setQuantity(quantity);
        productRepo.save(product.get());
        return QuantityResponse.builder().message("quantity added to product").success(true).build();
    }
}
