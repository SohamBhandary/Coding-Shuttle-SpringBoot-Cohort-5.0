package com.Soham.Module_9_Spring_AI.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.client.advisor.SafeGuardAdvisor;
import org.springframework.ai.chat.client.advisor.vectorstore.QuestionAnswerAdvisor;
import org.springframework.ai.chat.client.advisor.vectorstore.VectorStoreChatMemoryAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.document.Document;
import org.springframework.ai.embedding.EmbeddingModel;
import org.springframework.ai.reader.pdf.PagePdfDocumentReader;
import org.springframework.ai.transformer.splitter.TokenTextSplitter;
import org.springframework.ai.vectorstore.SearchRequest;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RAGService {

    private final ChatClient chatClient;
    private final EmbeddingModel embeddingModel;
    private final VectorStore vectorStore;
    private final ChatMemory chatMemory;

    @Value("classpath:SS.pdf")
    Resource pdfFile;

    public String askAiWithAdvisor(String prompt,String userId){

        return chatClient.prompt()
                .system("You are ai assistant cody greet user with your name like hi myself cody how can i help you answerin a friendly tone")
                .user(prompt).advisors(

//                        new SafeGuardAdvisor(List.of("Politics","Gaming")),


                        MessageChatMemoryAdvisor.builder(chatMemory).conversationId(userId)
                                        .build(),
                VectorStoreChatMemoryAdvisor.builder(vectorStore).conversationId(userId).defaultTopK(4).build(),
                        QuestionAnswerAdvisor.builder(vectorStore)
                                .searchRequest(SearchRequest.builder()
                                        .filterExpression("file_name == 'SS.pdf'")
                                        .topK(4)
                                        .build())
                                .build()


        ).call().content();
    }

    public String askAI(String query) {

        List<Document> documents = vectorStore.similaritySearch(
                SearchRequest.builder()
                        .query(query)
                        .topK(3)
                        .build()
        );

        String context = documents.stream()
                .map(Document::getText)
                .collect(Collectors.joining("\n\n"));

        System.out.println("=== Retrieved Context ===");
        System.out.println(context);

        String finalPrompt = """
            You are an AI assistant helping developers.

            Rules:
            1. Answer ONLY using the provided context.
            2. Do NOT use your own knowledge.
            3. If the answer is not present in the context, reply exactly:
               DONT KNOW

            Context:
            %s

            Question:
            %s
            """.formatted(context, query);

        return chatClient.prompt()
                .user(finalPrompt)
                .call()
                .content();
    }

    public void ingestPDFtoVectorDB(){
        PagePdfDocumentReader reader= new PagePdfDocumentReader(pdfFile);
        List<Document> pages= reader.get();

        TokenTextSplitter tokenTextSplitter= TokenTextSplitter.builder().withChunkSize(200).build();

      List<Document> chunks=  tokenTextSplitter.apply(pages);
      vectorStore.add(chunks);

    }
}
