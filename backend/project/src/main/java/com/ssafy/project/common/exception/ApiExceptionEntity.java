package com.ssafy.project.common.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiExceptionEntity {
    private String message;
    private String statusCode;

    public ApiExceptionEntity(String message, String statusCode) {
        this.message = message;
        this.statusCode = statusCode;
    }

    @Override
    public String toString() {
        return "ApiExceptionEntity [errorCode=" + statusCode + ", errorMessage=" + message + "]";
    }

}

