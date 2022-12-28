package org.ildus.akhamdiev.beanLifeCycle;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;


public class Prototype {
    @PostConstruct
    public void init() {
        System.out.println("Prototype init");
    }

    @PreDestroy
    public  void destroy() {
        System.out.println("Prototype destroy");
    }
}
