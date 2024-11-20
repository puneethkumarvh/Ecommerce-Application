package com.puneeth.EcomApp.controller;

import com.puneeth.EcomApp.model.Product;
import com.puneeth.EcomApp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @PostMapping("/product")
    public Product createProduct(@RequestBody Product product) {

        System.out.println("here in controller product");
        return productService.createProduct(product);
    }

//    @DeleteMapping("/{id}")
//    public void deleteProduct(@PathVariable Long id) {
//        productService.deleteProduct(id);
//    }
}
