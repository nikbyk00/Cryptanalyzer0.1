package com.example.cryptanalyzer;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 441, 338);
        stage.setTitle("cryptonalyzer");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in); // считываем текст с консоли.
        String text = console.nextLine();
        try {
            FileOutputStream outputStream = new FileOutputStream("encrypt");
            outputStream.write(text.getBytes(StandardCharsets.UTF_8)); // записываем текст в файл

            launch();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}