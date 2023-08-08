package com.example.storemanagementsystem.controllers;

import com.example.storemanagementsystem.dtos.CategoryDto;
import com.example.storemanagementsystem.entities.Category;
import com.example.storemanagementsystem.services.CategoryService;
import com.example.storemanagementsystem.utils.CommonUtils;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping("/getCategory")
    public ResponseEntity<CategoryDto> getCategoryById(@RequestParam Long categoryId) {
        CategoryDto categoryDto = categoryService.getCategoryById(categoryId).orElse(null);
        if (categoryDto != null) {
            return ResponseEntity.ok(categoryDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping(value = "/addCategory")
    public ResponseEntity<CategoryDto> createCompany(@RequestBody CategoryDto requestCategoryDto) {
        if (!CommonUtils.validateCategoryRequestDto(requestCategoryDto)){
            return ResponseEntity.badRequest().build();
        }
        CategoryDto foundCategoryDto = categoryService.saveCategory(requestCategoryDto).orElse(null);
        return new ResponseEntity<>(foundCategoryDto, HttpStatus.CREATED);
    }
}
