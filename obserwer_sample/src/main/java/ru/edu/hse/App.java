package ru.edu.hse;

import java.util.List;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {
        GameBlog kataku = new GameBlog(); // Социально справедливо.
        Gamer gamer = new Gamer("Expeky", kataku); // Продолжение читать в источнике...
        Journalist journalist = new Journalist("Jason Shrier", kataku); // Лучик света.
        Developer developer = new Developer("Todd Howard", kataku); // Не разраб, но как бы...
        kataku.setPost("Hogwards Legacy");
    }
}
