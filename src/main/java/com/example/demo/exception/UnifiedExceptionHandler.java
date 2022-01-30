package com.example.demo.exception;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.example.demo2.BusinessException;
import com.example.demo2.CommonResult;

@EnableWebMvc
@Configuration
public class UnifiedExceptionHandler {
    @RestControllerAdvice("com.example.demo")
    static class CommonExceptionHandler{
        @ExceptionHandler(BusinessException.class)
        public CommonResult<Void> handleBusinessException(BusinessException be){
            return CommonResult.errorResult(be.getErrorCode(), be.getErrorMsg());
        }
    } 
}
