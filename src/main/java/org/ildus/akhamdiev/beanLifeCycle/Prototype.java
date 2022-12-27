package org.ildus.akhamdiev.beanLifeCycle;

import org.springframework.stereotype.Component;

@Component
public class Prototype {
    public void init() {
        System.out.println("Prototype init");
    }

    public  void destroy() {
        System.out.println("Prototype destroy");
    }
}
