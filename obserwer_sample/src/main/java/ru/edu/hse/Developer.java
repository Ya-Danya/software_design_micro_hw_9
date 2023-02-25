package ru.edu.hse;

public class Developer implements ISubscriber {
    private String name;

    public Developer(String name, IBlog blog) {
        this.name = name;
        blog.addSubscriber(this);
    }

    public void update(String game) {
        System.out.println("Разработчик по имени " + name + " написал на хабре, что он умный.");
    }
}
