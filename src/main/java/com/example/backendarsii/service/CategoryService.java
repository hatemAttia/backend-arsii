package com.example.backendarsii.service;

import com.example.backendarsii.dto.responseDto.CategoryResponse;
import com.example.backendarsii.dto.requestDto.CategoryRequest;

import java.util.List;

public interface CategoryService {
    void addCategory (CategoryRequest categoryRequest);
    List<CategoryResponse> getAllCategories();
    CategoryResponse getCategoryById(Long id);
    void deleteCategory (Long id);
    void updateCategory(Long id,CategoryRequest categoryRequest);
}
