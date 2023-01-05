package org.ildus.akhmadiev.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.ArrayList;

public class Person {
    private static Long COUNT = 0L;
    private Long id;

    @NotEmpty(message = "name is null or \"\" ") @Size(min = 2,max = 10)
    private String name;
    @Min(value = 0,message = "min 0 ")
    private int age;
    @NotEmpty @Email
    private String email;

    public Person(Long id, @NotEmpty(message = "name is null or \"\" ") @Size(min = 2, max = 10) String name, @Min(value = 0, message = "min 0 ") int age, @NotEmpty @Email String email) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public long increment() {
        this.id = ++COUNT;
        return id;
    }

    public Person() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Person(String name, int age, String email) {
        this.id = ++COUNT;
        this.name = name;
        this.age = age;
        this.email = email;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
