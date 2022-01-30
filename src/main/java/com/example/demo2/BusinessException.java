package com.example.demo2;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BusinessException extends RuntimeException{
    
    private String errorCode;
    private String errorMsg;
}
