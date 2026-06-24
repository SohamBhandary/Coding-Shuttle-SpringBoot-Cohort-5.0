package com.Soham.Module_9_Spring_AI.Controller;


import com.Soham.Module_9_Spring_AI.Service.AiService;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.document.Document;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/ai")
public class AiController {

    private final AiService aiService;


    @GetMapping("/joke")
    public String joke(){
      return   aiService.getJoke("cricket");


    }

    @GetMapping("/embed")
    public float[] embed(){

         var res=  aiService.getEmbedding("cricket");

        return res;


    }

    @PostMapping("/ingest")
    public String ingestData(@RequestBody String text) {
        aiService.ingestDatatoVectorStore(text);
        return "Data ingested successfully!";
    }

    @PostMapping("/similarity")
    public List<Document> similartySerach(@RequestBody String text) {
        System.out.println("ok");
       return aiService.similaritySearch(text);

    }


}
