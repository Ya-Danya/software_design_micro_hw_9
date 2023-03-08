package ru.hse.edu;

import org.asynchttpclient.*;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Path;
import java.util.Scanner;

public class LoaderStream extends Thread{
    String  path;
    LoaderStream(String  path) {
        this.path = path;
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Пожалуйста, введите ссылку для скачивания.");
        String url = scanner.nextLine();

        FileOutputStream out_file_stream = null;
        BufferedInputStream in_buffer_stream = null;
        try {
            in_buffer_stream = new BufferedInputStream(new URL(url).openStream());
            System.out.println("Пожалуйста, введите название файла, который вы хотите сохранить.");
            String file_name = scanner.nextLine();
            out_file_stream = new FileOutputStream(path + "/" + file_name);
            byte[] data = new byte[1024];
            int count;
            while ((count = in_buffer_stream.read(data, 0 , 1024)) != -1) {
                out_file_stream.write(data, 0, 1024);
                out_file_stream.flush();
            }
        } catch (MalformedURLException e) {
            System.out.println("URL был введен некорректно.");
            throw new RuntimeException(e);
        } catch (IOException e) {
            System.out.println("Ошибка во время выполнения попытки скачать файл.");
            throw new RuntimeException(e);
        } finally {
            try {
                in_buffer_stream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            } finally {
                try {
                    out_file_stream.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

        }

    }
}
