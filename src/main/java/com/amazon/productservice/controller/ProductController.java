package com.amazon.productservice.controller;

import com.amazon.productservice.dto.request.CreateProductRequest;
import com.amazon.productservice.dto.response.CreateProductResponse;
import com.amazon.productservice.dto.response.GetProductResponse;
import com.amazon.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody CreateProductRequest request) {

        CreateProductResponse response = productService.save(request);
        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    @GetMapping
    public ResponseEntity<Object> fetchProductDetails(@RequestParam("id") int id) {

        GetProductResponse response = productService.fetchProductDetails(id);
        return new ResponseEntity<>(response, HttpStatus.OK);

    }
    @GetMapping("/test")
    public String test(){
        return "Hello User";
    }
}
