package com.example.backendarsii.service.serviceImpl;

import com.example.backendarsii.dto.responseDto.CategoryResponse;
import com.example.backendarsii.dto.requestDto.CategoryRequest;
import com.example.backendarsii.entity.Category;
import com.example.backendarsii.exception.ConflictException;
import com.example.backendarsii.exception.NotFoundException;
import com.example.backendarsii.repository.CategoryRepository;
import com.example.backendarsii.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {



    private final CategoryRepository categoryRepository;


    @Override
    public void addCategory(CategoryRequest categoryRequest) {

        if (categoryRepository.existsByName(categoryRequest.getName())){
            throw new ConflictException(String.format("this name ([%s]) is already exist ",categoryRequest.getName()));
        }
        Category category = Category.builder()
                .name(categoryRequest.getName())
                .description(categoryRequest.getDescription())
                .build();

        categoryRepository.save(category);

    }

    @Override
    public List<CategoryResponse> getAllCategories() {

        List<Category> categories = categoryRepository.findAll();
        List<CategoryResponse> categoryResponses = new ArrayList<>();

        for (Category category: categories) {

            CategoryResponse categoryResponse = CategoryResponse.makeCategory(category);
            categoryResponses.add(categoryResponse);
        }
        return categoryResponses;

    }

    @Override
    public CategoryResponse getCategoryById(Long id) {
        Category category = categoryRepository.findById(id).orElseThrow(
                ()->new NotFoundException(String.format("this id[%s] is not exist",id)));

        return CategoryResponse.makeCategory(category);
    }

    @Override
    public void deleteCategory(Long id) {

        if (!categoryRepository.existsById(id)){
            throw new NotFoundException(String.format("this id[%s] is not exist",id));
        }
        categoryRepository.deleteById(id);
    }

    @Override
    public void updateCategory(Long id, CategoryRequest categoryRequest) {

        Category category = categoryRepository.findById(id).orElseThrow(
                ()->new NotFoundException(String.format("this id[%s] is not exist",id)));
        if(!category.getName().equals(categoryRequest.getName()) && categoryRepository.existsByName(categoryRequest.getName())){
            throw  new ConflictException(String.format("this name is already exist ( [%s] ) ",categoryRequest.getName()));
        }
        category.setName(categoryRequest.getName());
        category.setDescription(categoryRequest.getDescription());

        categoryRepository.save(category);

    }
}
