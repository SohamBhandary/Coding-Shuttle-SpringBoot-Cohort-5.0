package com.codingshuttle.learn_spring_ai.controller;


import com.Soham.Module_9_Spring_AI.Tool.FlightBookingTools;
import com.Soham.Module_9_Spring_AI.Tool.TravellingTool;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ChatController {

    private final ChatClient chatClient;
    private final TravellingTool travellingTools;
    private final FlightBookingTools flightBookingTools;
    private final ChatMemory chatMemory;

    @PostMapping("/chat")
    public String chat(@RequestBody String message, @RequestParam String userId) {

        String systemPrompt = String.format("""
            You are a friendly flight booking assistant.
            Use the available tools to create, view, or update bookings.
            Always confirm actions with the user when possible.
            
            IMPORTANT: The current user's ID is "%s".
            When calling tools that require a userId, ALWAYS use this exact value.
            """, userId);

        return  chatClient.prompt()
                .system(systemPrompt)
                .user(message)
                .tools(travellingTools, flightBookingTools)
                .advisors(
                        MessageChatMemoryAdvisor.builder(chatMemory)
                                .conversationId(userId)
                                .build()
                )
                .call()
                .content();
    }
}
