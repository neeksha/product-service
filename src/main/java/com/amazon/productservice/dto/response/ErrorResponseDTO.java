package com.amazon.productservice.dto.response;

import lombok.Data;

@Data
public class ErrorResponseDTO {
    String errorCode;
    String message;
}
