package ru.edu.hse;

public class Journalist implements ISubscriber {
    private String name;

    public Journalist(String name, IBlog blog) {
        this.name = name;
        blog.addSubscriber(this);
    }

    public void update(String game) {
        System.out.println("Игровой журналист по имени " + name + " оценивает новую игру.");
    }
}
