package com.Soham.Module_2_SpringBoot_MVC.Advices;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ApiResponse <T>{
    private LocalDateTime time;
    private T data;
    private ApiError error;

    public ApiResponse(T data) {
        this();
        this.data = data;
    }

    public ApiResponse(ApiError error) {
        this();
        this.error = error;
    }

    public ApiResponse(){
        this.time= LocalDateTime.now();
    }
}