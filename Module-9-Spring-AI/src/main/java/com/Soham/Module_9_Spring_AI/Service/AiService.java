package com.Soham.Module_9_Spring_AI.Service;


import lombok.RequiredArgsConstructor;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.ai.document.Document;
import org.springframework.ai.embedding.EmbeddingModel;
import org.springframework.ai.vectorstore.SearchRequest;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.stream.Collectors;

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
//    public void loadSampleData() {
//
//        List<Document> documents = List.of(
//
//                new Document("""
//                    Spring Boot is a Java framework used to build production-ready applications.
//                    It provides auto-configuration, embedded servers, dependency injection,
//                    REST APIs, security, and database integration.
//                    Spring Boot simplifies enterprise application development by reducing
//                    configuration and boilerplate code.
//                    """),
//
//                new Document("""
//                    Cricket is one of the most popular sports in the world.
//                    It is played between two teams of eleven players.
//                    Major tournaments include the ICC Cricket World Cup,
//                    ICC Champions Trophy, and T20 World Cup.
//                    Virat Kohli, Rohit Sharma, and MS Dhoni are among India's
//                    most famous cricketers.
//                    """),
//
//                new Document("""
//                    Artificial Intelligence is a branch of computer science that focuses
//                    on building systems capable of performing tasks that normally require
//                    human intelligence. Machine learning, deep learning, natural language
//                    processing, and computer vision are important areas of AI.
//                    """),
//
//                new Document("""
//                    Football is the world's most popular sport.
//                    Players compete to score goals by moving a ball into the opponent's net.
//                    Famous clubs include Barcelona, Real Madrid, Manchester United,
//                    Liverpool, and Bayern Munich.
//                    """),
//
//                new Document("""
//                    PostgreSQL is an open-source relational database management system.
//                    PgVector is an extension for PostgreSQL that enables storage and
//                    querying of vector embeddings. It is commonly used in AI applications
//                    for semantic search and Retrieval-Augmented Generation (RAG).
//                    """)
//        );
//
//        vectorStore.add(documents);
//    }

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
