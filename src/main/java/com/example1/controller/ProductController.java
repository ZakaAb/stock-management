package com.example1.controller;


import com.example1.model.Product;
import com.example1.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    ProductRepository productRepository;


    @PostMapping("/product")
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        return new ResponseEntity<>(productRepository.save(product), HttpStatus.CREATED);
    }

    @GetMapping("/product")
    public ResponseEntity<Page<Product>> getAllProduct(@RequestParam(defaultValue = "0") int page,
                                                       @RequestParam(defaultValue = "5") int size) {
        Pageable paging = PageRequest.of(page, size);

        Page<Product> products = productRepository.findAll(paging);


        return new ResponseEntity<>(products, HttpStatus.OK);
    }
}
