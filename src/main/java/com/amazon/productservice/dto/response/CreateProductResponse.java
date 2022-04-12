package com.amazon.productservice.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateProductResponse {
    private int id;
    private String name;
    private String type;
    private float price;
}
