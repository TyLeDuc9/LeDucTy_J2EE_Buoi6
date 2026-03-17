package com.example.demo3.controller;

import com.example.demo3.model.Category;
import com.example.demo3.service.CategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    // Lấy tất cả danh mục
    @GetMapping
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }

    // Lấy danh mục theo id
    @GetMapping("/{id}")
    public Category getCategoryById(@PathVariable Integer id) {
        return categoryService.getCategoryById(id);
    }

    // Thêm danh mục
    @PostMapping
    public Category createCategory(@RequestBody Category category) {
        categoryService.saveCategory(category);
        return category;
    }

    // Cập nhật danh mục
    @PutMapping("/{id}")
    public Category updateCategory(@PathVariable Integer id, @RequestBody Category category) {

        Category existingCategory = categoryService.getCategoryById(id);

        if (existingCategory != null) {
            existingCategory.setName(category.getName());
            categoryService.saveCategory(existingCategory);
            return existingCategory;
        }

        return null;
    }

    // Xóa danh mục
    @DeleteMapping("/{id}")
    public String deleteCategory(@PathVariable Integer id) {
        categoryService.deleteCategory(id);
        return "Delete category success";
    }

}