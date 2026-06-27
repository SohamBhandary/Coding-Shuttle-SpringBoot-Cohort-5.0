package com.Soham.Module_2_SpringBoot_MVC.Advices;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@Builder
public class ApiError {
    private HttpStatus status;
    private String msg;
}
