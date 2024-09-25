package com.service.product.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponse {
    private Long id;
    private String name;
    private String brand;
    private Integer stock;
    private String category;
    private BigDecimal price;
    private String status;
    private String sku;
}
