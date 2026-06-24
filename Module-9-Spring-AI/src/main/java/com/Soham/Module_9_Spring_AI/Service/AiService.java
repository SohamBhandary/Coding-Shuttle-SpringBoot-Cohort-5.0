package com.Soham.Module_9_Spring_AI.Service;


import lombok.RequiredArgsConstructor;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor

public class AiService {

    private final ChatClient chatClient;

    public String getJoke(String topic){

        String systemPrompt= """
                
                You are a sractatic joker make 4 lines of peoetic joke,
                you will stricly stick to the topic as well, make it about politics
                
                
                """;

        PromptTemplate promptTemplate= new PromptTemplate(systemPrompt);
        String rendertext=promptTemplate.render(Map.of("topic",topic));



     var response=   chatClient.prompt()

        .user(rendertext).call().chatClientResponse();

     return  response.chatResponse().getResult().getOutput().getText();


    }
}
