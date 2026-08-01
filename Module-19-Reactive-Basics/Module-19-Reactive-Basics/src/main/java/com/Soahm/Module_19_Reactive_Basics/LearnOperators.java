package com.Soahm.Module_19_Reactive_Basics;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.comparator.Comparators;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
@Component
public class LearnOperators {

    public void learnAggs() {


        Mono<String> mono = Mono.just("Elephant");

        Mono.just("Hello")
                .repeat(3);
//                .subscribe(System.out::println);

        CompletableFuture<String> cf = mono.toFuture();


        Mono.just("Process this")
                .doOnNext(data -> System.out.println("Processing: " + data))
                .then(Mono.just("Final Result"))
                .subscribe(System.out::println);

        Flux<String> fruits = Flux.just("apple", "banana", "cherry", "date", "eggs");
        Flux<String> colors = Flux.just("red", "yellow", "black", "brown", "white");

        Flux
                .zip(fruits, colors, (fruit, color) -> fruit+" is "+color)
                .collectList();
//                .subscribe(
//                        (data) -> log.info("Data: {}", data)
//                );


        Flux<String> moreFruits = Flux.just("fig", "grape");

        Flux.merge(fruits, moreFruits);

        fruits
                .mergeWith(moreFruits);


//        fruits.groupBy(fruit -> fruit.length())
//                .flatMap(group -> group.collectList()
//                        .map(list -> group.key() + " -> " + list))
//                .subscribe(System.out::println);

//        fruits
//                .filter(fruit -> fruit.length() > 5)
//                .subscribe(
//                        (data) -> log.info("Data: {}", data)
//                );

//        fruits
////                .skip(2)
////                .take(3)
//                .sort(Comparator.reverseOrder())
//                .subscribe(
//                        (data) -> log.info("Data: {}", data)
//                );


    }

    public void learnMaps() {

        Flux<Integer> counts = Flux.range(4, 8);

        Flux<Long> ticks = Flux.interval(Duration.ofSeconds(1));

//        ticks.subscribe(
//                (count) -> log.info("Tick: {}", count)
//        );

        Mono<String> fromCallable = Mono.fromCallable(
                () -> slowTask()
        );


        Flux<String> fruits = Flux.just("apple", "banana", "cherry", "date", "eggs");


        Flux<String> flux = fruits
                .map(fruit -> fruit.toUpperCase())
                .map(upperCaseFruit -> upperCaseFruit.substring(0, 2))
                .flatMap(twoChars -> Flux.just(twoChars+"@", twoChars+"#"));

//                .subscribe(
//                        (data) -> log.info("Fruit: {}", data)
//                );

        flux.subscribe(
                (data) -> log.info("Data: {}", data)
        );


    }

    private String slowTask() {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return "some data";
    }

}
