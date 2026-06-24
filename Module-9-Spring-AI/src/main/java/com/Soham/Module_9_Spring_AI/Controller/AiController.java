package com.Soham.Module_9_Spring_AI.Controller;


import com.Soham.Module_9_Spring_AI.Service.AiService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/ai")
public class AiController {

    private final AiService aiService;


    @GetMapping("/joke")
    public String joke(){
      return   aiService.getJoke("cricket");
    }


}
