package com.service.product.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.product.model.Product;
import com.service.product.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    // Get all product
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    // Get product by id
    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    // Add new product / update product
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    // Delete product
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    // Get product by name
    public Optional<Product> getProductByName(String name) {
        return productRepository.findByname(name);
    }

    public Optional<Product> getProductBySku(String sku) {
        return productRepository.findBysku(sku);
    }

}
