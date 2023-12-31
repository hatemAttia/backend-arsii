package com.example.backendarsii.controller.adminController;

import com.example.backendarsii.dto.requestDto.CategoryRequest;
import com.example.backendarsii.dto.responseDto.CategoryResponse;
import com.example.backendarsii.service.CategoryService;
import com.example.backendarsii.utils.Constants;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(Constants.APP_ROOT_ADMIN+"/category")
@Api(tags = "(Admin) Category Management ")
public class CategoryAdminController {

    private final CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<CategoryResponse>> getAllCategories() {
        return ResponseEntity.ok(categoryService.getAllCategories());
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<CategoryResponse> getCategoryById(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(categoryService.getCategoryById(id));
    }
    @PostMapping
    public ResponseEntity<String> addCategory(@RequestBody @Valid CategoryRequest request){
        categoryService.addCategory(request);
        return ResponseEntity.ok("save success !");
    }
    @DeleteMapping(value = "{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable(name = "id") Long id){
        categoryService.deleteCategory(id);
        return ResponseEntity.ok("delete success !");
    }
    @PutMapping(value = "{id}")
    public ResponseEntity<String> updateCategory(
            @PathVariable(name = "id") Long id,
            @RequestBody @Valid CategoryRequest request){

        categoryService.updateCategory(id,request);
        return ResponseEntity.ok("update success !!!");
    }
}
