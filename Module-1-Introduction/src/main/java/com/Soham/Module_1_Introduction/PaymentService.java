package com.Soham.Module_1_Introduction;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

@Component
//@Service
//@Repository
//@RestController
public class PaymentService {
    public void  pay(){
        System.out.println("Paying....................");
    }
    @PostConstruct
    public  void  afterIni(){
        System.out.println("Before Paying");
    }

    @PreDestroy
    public  void  beforeDestory(){
        System.out.println("After Paying");
    }
}
