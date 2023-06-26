package com.example.planner.service;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.example.planner.dto.ProductDTO;
import com.example.planner.model.Product;
import com.example.planner.repository.ProductRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepo productRepository;


    public List<Product> getAllProducts() {
        return productRepository.findAll();
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
