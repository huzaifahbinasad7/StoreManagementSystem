package com.example.storemanagementsystem.dtos;

import com.example.storemanagementsystem.entities.Supplier;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * A DTO for the {@link Supplier} entity
 */
@Data
public class SupplierDto implements Serializable {
    private final Long id;
    private final String name;
    private final String contactNumber;
    private final String email;
    private final List<ProductDto> productList;
}