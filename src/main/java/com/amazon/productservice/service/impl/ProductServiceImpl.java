package com.amazon.productservice.service.impl;

import com.amazon.productservice.dao.entities.Product;
import com.amazon.productservice.dao.respository.ProductRepository;
import com.amazon.productservice.dto.request.CreateProductRequest;
import com.amazon.productservice.dto.response.CreateProductResponse;
import com.amazon.productservice.dto.response.GetProductResponse;
import com.amazon.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.amazon.productservice.exceptions.ResourceNotFoundException;
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;
    @Override
    public CreateProductResponse save(CreateProductRequest request) {
        Product product=Product.builder()
                                .name(request.getName())
                                .price(request.getPrice())
                                .type(request.getType())
                                .build();
        Product savedProduct=productRepository.save(product);

        CreateProductResponse response=CreateProductResponse.builder()
                                                            .id(savedProduct.getId())
                                                            .name(savedProduct.getName())
                                                            .price(savedProduct.getPrice())
                                                            .type(savedProduct.getType())
                                                            .build();

        return response;
    }

    @Override
    public GetProductResponse fetchProductDetails(int id) {
        Product product=productRepository.findById(id).orElse(null);
        if(product!=null) {
            GetProductResponse response = GetProductResponse.builder()
                    .id(product.getId())
                    .name(product.getName())
                    .price(product.getPrice())
                    .type(product.getType())
                    .build();

            return response;
        }else {
            throw new ResourceNotFoundException("Product not found in db");
        }
    }
}
