package com.example.storemanagementsystem.utils;


import com.example.storemanagementsystem.dtos.CategoryDto;


public class CommonUtils {

    public static boolean isNullOrEmptyString(String string) {
        return string == null || "null".equals(string) || "".equals(string.trim());
    }

    public static boolean validateCategoryRequestDto(CategoryDto categoryDto){
        boolean result=false;
        if (null!=categoryDto && categoryDto.getId()>0 && isNullOrEmptyString(categoryDto.getName())){
            result=true;
        }
        return result;
    }

}
