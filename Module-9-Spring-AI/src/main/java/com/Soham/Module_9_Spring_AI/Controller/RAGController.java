package com.Soham.Module_9_Spring_AI.Controller;

import com.Soham.Module_9_Spring_AI.Service.RAGService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rag")
@RequiredArgsConstructor
public class RAGController {
    private final RAGService ragService;
    @PostMapping("/ingest-pdf")
    public String ingestPdf() {

        ragService.ingestPDFtoVectorDB();

        return "PDF ingested successfully!";
    }

    @PostMapping("/advisor")
    public String askWithAdvisor(
            @RequestParam String userId,
            @RequestBody String prompt) {

        return ragService.askAiWithAdvisor(prompt, userId);
    }
}
