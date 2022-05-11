package com.example.cryptanalyzer;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
/*
 В этом классе мы зашифровываем текст в методе
 "entryText" с помощью ключа.
 */

public class Encryption {
    public static void encryptText(){
        try (
                FileInputStream  inputStream = new FileInputStream("encrypt");
                InputStreamReader streamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
                FileOutputStream outputStream = new FileOutputStream("decrypt");
        ) {
            ArrayList<String> listAlphabet = new ArrayList<>();
            Alphabet.fillingWithSymbols(listAlphabet); // заполняем Array List значениями из Алфавита.
            System.out.println("Зашифруем с помощью ключа --->  ");

            while (streamReader.ready()) { // считываем байт из потока и кладём в String token.
                int b = streamReader.read();
                char ch = (char) b;
                String token = Character.toString(ch);

                for (int i = 0; i < listAlphabet.size(); i++) {  // цикл по элементам ArrayList listAlphabet.
                    if(token.equals(listAlphabet.get(i))){    // сравниваем каждый элемент listAlphabet с token (байтом из потока).
                        token = listAlphabet.get(i + 3); // если они равны, кодируем с помощью ключа +3.
                        outputStream.write(token.getBytes(StandardCharsets.UTF_8)); // выводим в файл "decrypt".
                        System.out.print(token);
                        break;
                    }
                }
            }
        }   catch (IOException e) {
            e.printStackTrace();
        }
    }
}
