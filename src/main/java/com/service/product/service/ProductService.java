package com.service.product.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.product.dto.ProductResponse;
import com.service.product.model.Product;
import com.service.product.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    // Get all product
    public List<ProductResponse> getAllProduct() {
        List<Product> products = productRepository.findAll();
        return products.stream().map(this::convertToProductResponse).toList();
    }

    // Get product by id
    public Optional<ProductResponse> getProductById(Long id) {
        Optional<Product> product = productRepository.findById(id);
        return product.map(this::convertToProductResponse);
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
    public Optional<ProductResponse> getProductByName(String name) {
        Optional<Product> product = productRepository.findByname(name);
        return product.map(this::convertToProductResponse);
    }

    public Optional<ProductResponse> getProductBySku(String sku) {
        Optional<Product> product = productRepository.findBysku(sku);
        return product.map(this::convertToProductResponse);
    }

    private ProductResponse convertToProductResponse(Product product) {
        return new ProductResponse(
                product.getId(),
                product.getName(),
                product.getBrand(),
                product.getStock(),
                product.getCategory(),
                product.getPrice(),
                product.getStatus(),
                product.getSku());
    }
}
