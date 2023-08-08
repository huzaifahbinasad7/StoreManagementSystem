package com.example.storemanagementsystem.dtos;

import com.example.storemanagementsystem.entities.Product;
import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link Product} entity
 */
@Data
public class ProductDto implements Serializable {
    private final Long id;
    private final String name;
    private final String description;
    private final double price;
    private final int quantityInStock;
}