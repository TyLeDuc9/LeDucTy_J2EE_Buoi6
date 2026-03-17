package com.example.demo3.service;

import com.example.demo3.model.Product;
import com.example.demo3.repository.ProductRepository;
import com.example.demo3.repository.CategoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public void saveProduct(Product product) {
        productRepository.save(product);
    }

    public Product getProductById(int id) {
        return productRepository.findById((long) id).orElse(null);
    }

    public void deleteProduct(int id) {
        productRepository.deleteById((long) id);
    }

}