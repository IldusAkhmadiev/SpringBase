package org.ildus.akhamdiev.beanLifeCycle;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;


public class Singleton {

//    {
//        System.out.println("NON STATIC INIT");
//    }
//
//    static {
//        System.out.println("STATIC INIT");
//    }
//
//    public Singleton() {
//        System.out.println("Constructor ");
//    }

    @PostConstruct
    public void init() {
        System.out.println("Singleton init");
    }
    @PreDestroy
    public  void destroy() {
        System.out.println("Singleton destroy");
    }
}
