package com.example.crudapi.controller;

import com.example.crudapi.entity.Product;
import com.example.crudapi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductService service;

    @PostMapping("/product")
    public Product addProduct(@RequestBody Product product) {
        return service.saveProduct(product);
    }

    @PostMapping("/products")
    public List<Product> addProducts(@RequestBody List<Product> products) {
        return service.saveProducts(products);
    }

    @PutMapping("/products/update")
    public Product updateProduct(@RequestBody Product product) {
        return service.updateProduct(product);
    }

    @DeleteMapping("/products/delete/{id}")
    public Boolean deleteProduct(@PathVariable int id) {
        return service.deleteProduct(id);
    }

    @GetMapping("products")
    public List<Product> findAllProducts() {
        return service.getProducts();
    }

    @GetMapping("products/id/{id}")
    public Product findProductById(@PathVariable int id) {
        return service.getProductById(id);
    }

    @GetMapping("products/name/{name}")
    public Product findProductsByName(@PathVariable String name) {
        return service.getProductByName(name);
    }
}
