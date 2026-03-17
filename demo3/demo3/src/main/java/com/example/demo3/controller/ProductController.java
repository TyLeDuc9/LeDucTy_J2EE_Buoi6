package com.example.demo3.controller;

import com.example.demo3.model.Product;
import com.example.demo3.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    // Lấy tất cả sản phẩm
    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    // Lấy sản phẩm theo ID
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable int id) {
        return productService.getProductById(id);
    }

    // Thêm sản phẩm
    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        productService.saveProduct(product);
        return product;
    }

    // Cập nhật sản phẩm
    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable int id, @RequestBody Product product) {

        Product existingProduct = productService.getProductById(id);

        if (existingProduct != null) {
            existingProduct.setName(product.getName());
            existingProduct.setPrice(product.getPrice());
            existingProduct.setImage(product.getImage());
            existingProduct.setCategory(product.getCategory());

            productService.saveProduct(existingProduct);
            return existingProduct;
        }

        return null;
    }

    // Xóa sản phẩm
    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable int id) {
        productService.deleteProduct(id);
        return "Delete product success";
    }

}