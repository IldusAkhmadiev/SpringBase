package org.ildus.akhamdiev.base_core;

import org.springframework.stereotype.Component;

@Component
public class BeanEx {
    private String name;

    public BeanEx() {
        System.out.println("BeanEX init");
    }

    public BeanEx(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
