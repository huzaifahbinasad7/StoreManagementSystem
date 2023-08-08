package com.example.storemanagementsystem.entities;

import lombok.*;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String contactNumber;
    private String email;

    @OneToMany(mappedBy = "supplier")
    private List<Product> productList;
}

