package com.doitgeek.oc.authserver.exception;

import com.doitgeek.oc.authserver.constant.AppConstant;
import com.doitgeek.oc.authserver.constant.ErrorMessageConstant;
import com.doitgeek.oc.authserver.model.ApiResponseModel;
import io.micrometer.core.lang.NonNullApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
@NonNullApi
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomExceptionHandler.class);

    // Handle all other exceptions
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleAllException(Exception ex) {
        LOGGER.error(ex.getMessage(), ex);
        ApiResponseModel<String> apiResponseModel = new ApiResponseModel<>();
        apiResponseModel.setStatus(AppConstant.ERROR);
        apiResponseModel.setErrorMessage(ex.getMessage());
        return new ResponseEntity<>(apiResponseModel, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // Handle UserNotFoundException
    @ExceptionHandler(UserAccountNotFoundException.class)
    public ResponseEntity<?> handleUserNotFoundException(UserAccountNotFoundException ex) {
        LOGGER.error(ex.getMessage(), ex);
        ApiResponseModel<String> apiResponseModel = new ApiResponseModel<>();
        apiResponseModel.setStatus(AppConstant.ERROR);
        apiResponseModel.setErrorMessage(ex.getMessage());
        return new ResponseEntity<>(apiResponseModel, HttpStatus.NOT_FOUND);
    }

    // Handle validation errors
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatus status, WebRequest request) {
        LOGGER.error(ex.getMessage(), ex);
        Map<String, String> errorMessageMap = new HashMap<>();
        ex.getBindingResult()
                .getFieldErrors()
                .forEach(fieldError -> errorMessageMap.put(fieldError.getField(), fieldError.getDefaultMessage()));

        ApiResponseModel<String> apiResponseModel = new ApiResponseModel<>();
        apiResponseModel.setStatus(AppConstant.ERROR);
        apiResponseModel.setErrorMessage(ErrorMessageConstant.VALIDATION_FAILED);
        apiResponseModel.setErrorMessages(errorMessageMap);

        return new ResponseEntity<>(apiResponseModel, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<?> handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException ex) {
        LOGGER.error(ex.getMessage(), ex);
        ApiResponseModel<String> apiResponseModel = new ApiResponseModel<>();
        apiResponseModel.setStatus(AppConstant.ERROR);
        String errorMessage = String.format(ErrorMessageConstant.METHOD_ARG_TYPE_MISMATCH, ex.getName(),
                                    ex.getRequiredType() != null ? ex.getRequiredType().getName() : "");
        apiResponseModel.setErrorMessage(errorMessage);
        return new ResponseEntity<>(apiResponseModel, HttpStatus.BAD_REQUEST);
    }
}
