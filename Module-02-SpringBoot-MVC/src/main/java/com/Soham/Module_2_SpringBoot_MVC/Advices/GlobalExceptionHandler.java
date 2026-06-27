package com.Soham.Module_2_SpringBoot_MVC.Advices;


import com.Soham.Module_2_SpringBoot_MVC.Exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse<?>> handleResourceNotFound(ResourceNotFoundException exception){
        ApiError apiError=ApiError.builder().
                status(HttpStatus.NOT_FOUND).
                msg(exception.getMessage()).build();
        return buildErrorResponseEntity(apiError);
    }


    @ExceptionHandler(Exception.class)

        public ResponseEntity<ApiResponse<?>> handleInternalServal(Exception exception){
            ApiError apiError=ApiError.builder().
                    status(HttpStatus.INTERNAL_SERVER_ERROR).
                    msg(exception.getMessage()).build();
        return buildErrorResponseEntity(apiError);

    }

    @ExceptionHandler(MethodArgumentNotValidException.class)

    public ResponseEntity<ApiError> handleInputValidationErorServal(MethodArgumentNotValidException exception){
     List<String> errors=  exception.getBindingResult()
             .getAllErrors()
             .stream().map(e->e.getDefaultMessage()).collect(Collectors.toList());

ApiError apiError=ApiError.builder().status(HttpStatus.BAD_REQUEST).msg(errors.toString()).build();
return new ResponseEntity<>(apiError,HttpStatus.BAD_REQUEST);


    }

    private ResponseEntity<ApiResponse<?>> buildErrorResponseEntity(ApiError apiError) {
        return new ResponseEntity<>(new ApiResponse<>(apiError),apiError.getStatus());
    }

}
