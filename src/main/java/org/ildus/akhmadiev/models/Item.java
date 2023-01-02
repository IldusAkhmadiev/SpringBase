package org.ildus.akhmadiev.models;

public class Item {
    private static long COUNT;
    private Long id;
    private String name;
    private Double weight;
    private String category;

    public Item() {
    }

    public Item(String name, Double weight, String category) {
        increment();
        this.name = name;
        this.weight = weight;
        this.category = category;
    }

    public long increment() {
        id =++COUNT;
        return id;
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

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
