package com.Soham.Module_9_Spring_AI.Service;


import lombok.RequiredArgsConstructor;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.ai.document.Document;
import org.springframework.ai.embedding.EmbeddingModel;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Vector;

@Service
@RequiredArgsConstructor

public class AiService {

    private final ChatClient chatClient;
    private final EmbeddingModel embeddingModel;
    private final VectorStore vectorStore;


    public float[] getEmbedding(String text) {

        return embeddingModel.embed(text);
    }

    public void ingestDatatoVectorStore(String text){
        Document document= new Document(text);
        vectorStore.add(List.of(document));
    }

    public List<Document> similaritySearch(String text){
      return   vectorStore.similaritySearch(text);
    }


    public String getJoke(String topic) {

        String systemPrompt = """
                
                You are a sractatic joker make 4 lines of peoetic joke,
                you will stricly stick to the topic as well, make it about politics
                
                
                """;

        PromptTemplate promptTemplate = new PromptTemplate(systemPrompt);
        String rendertext = promptTemplate.render(Map.of("topic", topic));


        var response = chatClient.prompt()

                .user(rendertext).call().chatClientResponse();

        return response.chatResponse().getResult().getOutput().getText();


    }
}
