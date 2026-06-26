package com.Soham.Module_9_Spring_AI.Advisor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.chat.client.ChatClientRequest;
import org.springframework.ai.chat.client.ChatClientResponse;
import org.springframework.ai.chat.client.advisor.api.CallAdvisor;
import org.springframework.ai.chat.client.advisor.api.CallAdvisorChain;
import org.springframework.ai.chat.model.ChatResponse;

@Slf4j
public class TokenUsageAdvicer implements CallAdvisor {

    @Override
    public ChatClientResponse adviseCall(ChatClientRequest chatClientRequest, CallAdvisorChain callAdvisorChain) {

        long startTime = System.currentTimeMillis();

        // 1. Pass the request down the chain (to the LLM)
        ChatClientResponse advisedResponse = callAdvisorChain.nextCall(chatClientRequest);

        // 2. Extract the actual LLM response
        ChatResponse chatResponse = advisedResponse.chatResponse();

        // 3. Inspect Usage Metadata
        if (chatResponse != null && chatResponse.getMetadata().getUsage() != null) {
            var usage = chatResponse.getMetadata().getUsage();
            long duration = System.currentTimeMillis() - startTime;

            log.info("💰 Token Usage: Input={} | Output={} | Total={} | Time={}ms",
                    usage.getPromptTokens(),
                    usage.getCompletionTokens(),
                    usage.getTotalTokens(),
                    duration);

            // make a db call to store the tokens count
        }

        return advisedResponse;
    }

    @Override
    public String getName() {
        return "ChatClientResponse";
    }

    @Override
    public int getOrder() {
        return 0;
    }
}