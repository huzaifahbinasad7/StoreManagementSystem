package com.example.storemanagementsystem.dtos;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * A DTO for the {@link com.example.storemanagementsystem.entities.Category} entity
 */
@Data
public class CategoryDto implements Serializable {
    private final Long id;
    private final String name;
    private final String description;
    private final List<ProductDto> productsList;
}