package com.mistiloop.mistiloopWeb.service;

import com.mistiloop.mistiloopWeb.entity.Product;
import com.mistiloop.mistiloopWeb.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public List<Product> getProductsByCategory(String category) {
        return productRepository.findByCategory(category);
    }
    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }
}