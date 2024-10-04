package com.service.product.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.service.product.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findByname(String name);

    Optional<Product> findBysku(String sku);

    boolean existsBysku(String sku);

    // Custom query
    // @Query("SELECT p FROM Product p WHERE p.productName LIKE %:keyword%")
    // List<Product> search(@Param("keyword") String keyword);
}
