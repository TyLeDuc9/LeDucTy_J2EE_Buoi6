package com.example.demo3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CategoryViewController {

    @GetMapping("/categories")
    public String listCategory(){
        return "category/list";
    }

    @GetMapping("/categories/add")
    public String addCategory(){
        return "category/add";
    }
    @GetMapping("/categories/edit/{id}")
    public String editCategory(){
        return "category/edit";
    }

}