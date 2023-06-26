package com.example.planner.service;

import com.example.planner.dto.QuantityDTO;
import com.example.planner.dto.QuantityResponse;
import com.example.planner.model.Product;
import com.example.planner.model.Quantity;
import com.example.planner.repository.QuantityRepo;
import com.example.planner.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QuantityService {

    private final ProductService productService;
    private final QuantityRepo quantityRepo;
    public QuantityResponse addQuantityToProduct(Long productId, QuantityDTO quantityDTO) {
        // Retrieve the product by ID
        Product product = productService.getProductById(productId);
        if (product == null) {
            return QuantityResponse.builder().message("product does not exist").success(false).build();
        }

        // Create a new Quantity entity
        Quantity quantity = new Quantity();
        quantity.setQuantity(quantityDTO.getQuantity());
        quantity.setOperation(quantityDTO.getOperation());
        quantity.setDate(quantityDTO.getDate());
        quantityRepo.save(quantity);
        // Associate the Quantity with the Product
        product.setQuantity(quantity);

        // Save the updated Product with Quantity
        productService.saveProduct(product);
        return QuantityResponse.builder().message("quantity added to product").success(true).build();
    }
}
