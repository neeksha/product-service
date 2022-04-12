package com.amazon.productservice.service;

import com.amazon.productservice.dto.request.CreateProductRequest;
import com.amazon.productservice.dto.response.CreateProductResponse;
import com.amazon.productservice.dto.response.GetProductResponse;

public interface ProductService {

    CreateProductResponse save(CreateProductRequest request);

    GetProductResponse fetchProductDetails(int id);
}

