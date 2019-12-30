package com.doitgeek.oc.usermanagementservice.exception;

import com.doitgeek.oc.usermanagementservice.model.ApiResponseModel;

public class AuthServerFeignClientException extends RuntimeException {

    private static final long serialVersionUID = -1491285899668256415L;
    private ApiResponseModel apiResponseModel;
    private int status;

    public AuthServerFeignClientException(ApiResponseModel apiResponseModel, int status) {
        this.apiResponseModel = apiResponseModel;
        this.status = status;
    }

    public AuthServerFeignClientException(String message, ApiResponseModel apiResponseModel, int status) {
        super(message);
        this.apiResponseModel = apiResponseModel;
        this.status = status;
    }

    public AuthServerFeignClientException(String message, int status) {
        super(message);
        this.status = status;
    }

    public AuthServerFeignClientException(String message, Throwable cause) {
        super(message, cause);
    }

    public AuthServerFeignClientException(Throwable cause) {
        super(cause);
    }

    public ApiResponseModel getApiResponseModel() {
        return apiResponseModel;
    }

    public int getStatus() {
        return status;
    }
}
