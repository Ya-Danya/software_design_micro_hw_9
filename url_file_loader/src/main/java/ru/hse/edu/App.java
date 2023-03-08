package ru.hse.edu;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class App {
    public static void main( String[] args ) throws InterruptedException {
        // Осуществление выбора папки для сохранения файлов по-умолчанию.
        Scanner scanner = new Scanner(System.in);
        Path path;
        boolean flag = true;
        String str_path;
        // Пока пользователь не введет корректный путь или не напишет exit, продолжаем настойчиво требовать путь.
        do {
            // Если ввод осуществляется не в первый раз, а то есть была совершена ошибка,
            // то выводится сообщение о некорректном вводе.
            if (flag) {
                System.out.println("Введите путь по которому вы будете сохранять загружаемые файлы." +
                        " (Если вы хотите завершить работу приложения, введите exit");
            } else {
                System.out.println("Введенный путь не существует, пожалуйста, введите корректный путь." +
                        " (Если вы хотите завершить работу приложения, введите exit");
            }
            flag = false;
            // Читаем строку из консоли, если она равна exit, завершаем работу программы.
            str_path = scanner.nextLine();
            if (str_path.equals("exit")) {
                return;
            } else {
                path = Paths.get(str_path);
            }
        } while (!Files.exists(path));
        // Создаем поток в котором будет осуществлена загрузка файла по ссылке.
        LoaderStream loaderStream = new LoaderStream(str_path);
        while (true) {
            System.out.println("Выберете действие программы (Введите help для получения списка комманд)");
            String string = scanner.nextLine();
            switch (string){
                case "help" :
                    System.out.println("Введите select path для изменения пути сохранения файлов.");
                    System.out.println("Введите load для того, чтобы скачать файл.");
                    System.out.println("Введите exit для того, чтобы завершить работу приложения.");
                    break;
                case "select path" :
                    do {
                        System.out.println("Введите путь по которому вы будете сохранять загружаемые файлы.");
                        path = Paths.get(scanner.nextLine());
                    } while (Files.exists(path));
                case "load":
                    loaderStream.start();
                    loaderStream.join();
                    break;
                case "exit": return;
            }
        }
    }
}
