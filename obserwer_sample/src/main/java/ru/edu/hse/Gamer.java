package ru.edu.hse;

public class Gamer implements ISubscriber {
    private String name;

    public Gamer(String name, IBlog blog) {
        this.name = name;
        blog.addSubscriber(this);
    }

    public void update(String game) {
        System.out.println("Игрок по имени " + name + " пошел выбивать ачивки.");
    }
}
