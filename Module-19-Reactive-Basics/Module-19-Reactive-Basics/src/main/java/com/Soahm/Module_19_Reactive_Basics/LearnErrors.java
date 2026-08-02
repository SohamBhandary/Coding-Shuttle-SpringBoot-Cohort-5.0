package com.Soahm.Module_19_Reactive_Basics;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@Slf4j
public class LearnErrors {

    public void learnErrorHandling() {

        Mono<String> fromCallable = Mono.fromCallable(() -> {
            Thread.sleep(4000);
            throw new RuntimeException("Error occured");
        });

        fromCallable
                .doOnError(err -> log.error("error logged: {}", err.getMessage(), err))
//                .onErrorComplete()
//                .onErrorReturn("fallback data")
//                .onErrorResume((err) -> Mono.just("Fallback Mono"))
                .onErrorMap((err) -> new IllegalArgumentException("Illegal argument"))
                .subscribe(
                data -> log.info("data: {}", data)
        );

        log.info("After callable");

    }
}
