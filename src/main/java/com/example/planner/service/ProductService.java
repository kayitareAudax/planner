package com.example.planner.service;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.example.planner.dto.ProductDTO;
import com.example.planner.dto.ProductResponse;
import com.example.planner.model.Product;
import com.example.planner.repository.ProductRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepo productRepository;
    public List<ProductResponse> getAllProducts() {
        List<Product> products = productRepository.findAll();
        List<ProductResponse> productDTOs = new ArrayList<>();

        for (Product product : products) {
            ProductResponse productDTO = new ProductResponse();
            productDTO.setCode(product.getCode());
            productDTO.setName(product.getName());
            productDTO.setProductType(product.getProductType());
            productDTO.setInDate(product.getInDate());
            productDTO.setPrice(product.getPrice());
            productDTO.setQuantity(product.getQuantity().getQuantity()); // Retrieve the quantity value from the associated Quantity entity
            productDTOs.add(productDTO);
        }

        return productDTOs;
    }


    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    public Product createProduct(ProductDTO productDTO) throws IOException {
        Product product = new Product();
        product.setName(productDTO.getName());
        product.setProductType(productDTO.getProductType());
        product.setPrice(productDTO.getPrice());
        product.setInDate(productDTO.getInDate());
        return productRepository.save(product);
    }
    public Product saveProduct(Product product){
        return productRepository.save(product);
    }
}
