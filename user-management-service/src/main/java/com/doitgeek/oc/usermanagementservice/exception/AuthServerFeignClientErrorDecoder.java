package com.doitgeek.oc.usermanagementservice.exception;

import com.doitgeek.oc.usermanagementservice.model.ApiResponseModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Response;
import feign.codec.ErrorDecoder;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.Reader;

@Component
public class AuthServerFeignClientErrorDecoder implements ErrorDecoder {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthServerFeignClientErrorDecoder.class);
    private final ErrorDecoder defaultErrorDecoder = new Default();
    private static final String EXCEPTION_MESSAGE = "Exception from AuthServerFeignClient.";

    @Override
    public Exception decode(String methodKey, Response response) {
        LOGGER.info("Inside AuthServerFeignClientErrorDecoder -> decode()");
        if (response.status() >= 400 && response.status() <= 499) {
            ApiResponseModel apiResponseModel = null;
            try {
                Reader reader = response.body().asReader();
                String result = IOUtils.toString(reader);
                ObjectMapper objectMapper = new ObjectMapper();
                apiResponseModel = objectMapper.readValue(result, ApiResponseModel.class);
            } catch (Exception e) {
                LOGGER.error("Error while reading response body: ", e);
            }

            if (apiResponseModel != null) {
                return new AuthServerFeignClientException(EXCEPTION_MESSAGE, apiResponseModel, response.status());
            }
            return new AuthServerFeignClientException(response.reason(), response.status());
        }

        if (response.status() >= 500 && response.status() <= 599) {
            return new AuthServerFeignClientException("Internal Server Error", response.status());
        }
        return defaultErrorDecoder.decode(methodKey, response);
    }
}
