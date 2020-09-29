package com.example.restapplication.controllers;

import com.example.restapplication.entetities.Product;
import com.example.restapplication.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public List<Product> list() {
        return productService.getAllProducts();
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Product> get(@PathVariable Long id) {
        try {
            Product product = productService.getProduct(id);
            return new ResponseEntity<Product>(product, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/products")
    public void add(@RequestBody Product product) {
        productService.saveProduct(product);
    }

    @PutMapping("/products/{id}")
    public ResponseEntity<?> update(@RequestBody Product product, @PathVariable Long id) {
        try {
            Product existProduct = productService.getProduct(id);
            productService.saveProduct(product);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/products/{id}")
    public void delete(@PathVariable Long id) {
        productService.deleteProduct(id);
    }
}
