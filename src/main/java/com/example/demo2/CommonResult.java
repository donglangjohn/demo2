package com.example.demo2;

import lombok.Data;

@Data
public class CommonResult<T> {

    private int status = 1;
    private String errorCode = "";
    private String errorMsg = "";
    private T resultBody;

    public CommonResult() {}

    public CommonResult(T resultBody) {
        this.resultBody = resultBody;
    }
    
    public static <T> CommonResult<T> errorResult(String errorCode, String errorMsg) {
        CommonResult<T> commonResult = new CommonResult<>();
        commonResult.errorCode = errorCode;
        commonResult.errorMsg = errorMsg;
        commonResult.status = -1;
        return commonResult;
    }

}
