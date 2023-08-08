package com.example.storemanagementsystem.services;

import com.example.storemanagementsystem.dtos.CategoryDto;
import com.example.storemanagementsystem.entities.Category;
import com.example.storemanagementsystem.repositories.CategoryRepository;
import com.example.storemanagementsystem.utils.DtoToEntityConverter;
import com.example.storemanagementsystem.utils.EntityToDtoConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final DtoToEntityConverter dtoToEntityConverter;

    private final EntityToDtoConverter entityToDtoConverter;


    public Optional<CategoryDto> getCategoryById(Long categoryId){
        Category foundCategory = categoryRepository.findById(categoryId).orElse(null);
        if (foundCategory!=null){
            return Optional.of(entityToDtoConverter.convertToDto(foundCategory,CategoryDto.class));
        }
        return Optional.empty();
    }

    public Optional<CategoryDto> saveCategory(CategoryDto categoryDto) {
        Category category= dtoToEntityConverter.convertToEntity(categoryDto,Category.class);
        Category savedCategory = categoryRepository.save(category);
        if (null!=savedCategory){
            return Optional.of(entityToDtoConverter.convertToDto(savedCategory,CategoryDto.class));
        }
        return Optional.empty();
    }
}
