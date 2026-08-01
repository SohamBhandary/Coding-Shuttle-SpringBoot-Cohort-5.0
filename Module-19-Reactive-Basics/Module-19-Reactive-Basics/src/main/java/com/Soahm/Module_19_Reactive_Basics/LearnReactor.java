package com.Soahm.Module_19_Reactive_Basics;

import lombok.extern.slf4j.Slf4j;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.springframework.stereotype.Component;
import reactor.core.publisher.BaseSubscriber;
import reactor.core.publisher.Flux;
import reactor.core.publisher.SignalType;

import java.time.Duration;

@Slf4j
@Component
public class LearnReactor {

    public void learnReactor() {

//        Flux<String> fruits = Flux.just("apple", "lichi", "banana")
//                        .map(fruit -> {
//                            if(fruit.equals("banana")) throw new RuntimeException("No likey banana");
//                            return fruit;
//                        });

        Flux<String> flux = Flux.interval(Duration.ofSeconds(1))
                .map(tick -> "tick: "+tick);

        flux
                .doOnSubscribe((subscription) -> log.info("onSubscribeHook"))
                .doOnNext(item -> log.info("logging: {}", item)) // logging
                .subscribe(
                        item -> {
                            log.info("Processing: {}", item); // do operation here
                        },
                        err -> {
                            log.error("onError ", err);
                        },
                        () -> {
                            log.info("onComplete");
                        }
                );

//        flux.subscribe(new BaseSubscriber<String>() {
//            @Override
//            protected void hookOnSubscribe(Subscription subscription) {
//                log.info("hookOnSubscribe");
//                request(1);
//            }
//
//            @Override
//            protected void hookOnNext(String value) {
//                log.info("Processing: {}", value);
//                if (value.equals("lichi")) cancel();
//                request(1);
//            }
//
//            @Override
//            protected void hookOnComplete() {
//                log.info("hookOnComplete");
//            }
//
//            @Override
//            protected void hookOnError(Throwable throwable) {
//                log.info("hookOnError {}", throwable.getMessage(), throwable);
//            }
//
//            @Override
//            protected void hookOnCancel() {
//                log.info("hookOnCancel");
//            }
//
//            @Override
//            protected void hookFinally(SignalType type) {
//                log.info("hookFinally");
//            }
//        });


//        fruits
//                .subscribe(
//                        new Subscriber<>() {
//                            Subscription subscription;
//
//                            @Override
//                            public void onSubscribe(Subscription s) {
//                                subscription = s;
//                                log.info("onSubscribe");
//                                s.request(1);
//                            }
//
//                            @Override
//                            public void onNext(String s) {
//                                log.info("Fruit: {}", s);
//                                subscription.request(1);
//                            }
//
//                            @Override
//                            public void onError(Throwable t) {
//                                log.error("onError {}", t.getMessage());
//                            }
//
//                            @Override
//                            public void onComplete() {
//                                log.info("onComplete");
//                            }
//                        }
//                );
    }

}
