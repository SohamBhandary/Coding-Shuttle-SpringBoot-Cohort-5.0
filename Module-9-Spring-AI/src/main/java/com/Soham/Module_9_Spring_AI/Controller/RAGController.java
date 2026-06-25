package com.Soham.Module_9_Spring_AI.Controller;

import com.Soham.Module_9_Spring_AI.Service.RAGService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
