package com.Soham.Module_20_Webflux.Controller;

import lombok.Getter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/benchmark")
public class BenchmarkController {
    @GetMapping("/users/{id}")
    public String getFullUser(@PathVariable Long id ) throws InterruptedException {
        Thread.sleep(1000);
        return "Full user"+id;

    }
}
