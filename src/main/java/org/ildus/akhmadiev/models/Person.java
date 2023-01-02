package org.ildus.akhmadiev.models;

import java.util.ArrayList;

public class Person {
    private static Long COUNT = 0L;
    private Long id;
    private String name;

    public void increment() {
        this.id = ++COUNT;
    }

    public Person() {
    }

    public Person(String name) {
        this.id = ++COUNT;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
