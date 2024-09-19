package com.service.product.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.service.product.model.Product;
import com.service.product.repository.ProductRepository;
import com.service.product.service.ProductService;



@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;
    @SuppressWarnings("unused")
    private ProductRepository productRepository;

    // Get all product
    @GetMapping
    public List<Product> getAllProduct() {
        return productService.getAllProduct();
    }

    // Get product by id
    @GetMapping("/{id}")
    public Optional<Product> getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    // Add new product
    @Transactional
    @PostMapping
    public Product saveProduct(@RequestBody Product product) {
        if (productService.getProductBySku(product.getSku()) != null) {
            return productService.saveProduct(product);
        } else {
            return null;
        }
    }

    // Update product
    @PutMapping("/{id}")
    public Product update(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

    // Delete product
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }

    // Get product by name
    @GetMapping("/find/name/{name}")
    public Optional<Product> getProductByName(@PathVariable String name) {
        return productService.getProductByName(name);
    }

    // Get product by sku
    @GetMapping("/find/sku/{sku}")
    public Optional<Product> getProductBySku(@PathVariable String sku) {
        return productService.getProductBySku(sku);
    }
}
