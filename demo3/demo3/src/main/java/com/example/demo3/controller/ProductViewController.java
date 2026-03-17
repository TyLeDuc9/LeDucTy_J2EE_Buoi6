package com.example.demo3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ProductViewController {

    @GetMapping("/products")
    public String listProduct(){
        return "product/list";
    }

    @GetMapping("/products/add")
    public String addProduct(){
        return "product/add";
    }

    @GetMapping("/products/edit/{id}")
    public String editProduct(@PathVariable int id){
        return "product/edit";
    }

}