package com.example.cryptanalyzer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

/*
 В этом классе мы расшифровываем текст в методе
 "decryptionOfTheText" с помощью ключа.
 */
public class Decryption {
    public static void decryptionOfTheText() {
        try (
                FileInputStream inputStream = new FileInputStream("decrypt");
                InputStreamReader streamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8); // считываем с файла зашифрванный текст.
        ) {
            ArrayList<String> listAlphabet = new ArrayList<>();
            Alphabet.fillingWithSymbols(listAlphabet); // заполняем Array List значениями из Алфавита.
            System.out.println();
            System.out.println("Расшифруем с помощью ключа --->  ");

            while (streamReader.ready()) {  //считываем байт из потока и кладём в String token.
                int b = streamReader.read();
                char ch = (char) b;
                String token = Character.toString(ch);

                for (int i = 0; i < listAlphabet.size(); i++) { // цикл по элементам listAlphabet.
                    if(token.equals(listAlphabet.get(i))){ // сравниваем каждый элемент listAlphabet с token (байтом из потока).
                        token = listAlphabet.get(i - 3); // если они одинаковые, раскодируем с помощью ключа -3.
                        System.out.print(token); // выводим на экран.
                        break;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
