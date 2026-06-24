package com.Soham.Module_9_Spring_AI.Service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AiServiceTest {

    @Autowired
    private AiService aiService;

    @Test
    public void testGetJoke(){
       var joke= aiService.getJoke("dog");
        System.out.println(joke);
    }
}
