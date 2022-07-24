package com.example.cryptanalyzer;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
/*
 В этом классе мы зашифровываем текст в методе
 "entryText" с помощью ключа.
 */

public class Encryption {
    private ArrayList<String> listAlphabet;
    private FileInputStream inputStream;
    private FileOutputStream outputStream;
    private InputStreamReader streamReader;
    private FileInputStream inputStreamDecrypt;
    private InputStreamReader streamReaderDecrypt;


    {
        try {
            inputStream = new FileInputStream("encrypt");
            outputStream = new FileOutputStream("decrypt");
            streamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
            inputStreamDecrypt = new FileInputStream("decrypt");
            streamReaderDecrypt = new InputStreamReader(inputStreamDecrypt, StandardCharsets.UTF_8);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public Encryption(ArrayList<String> listAlphabet) {
        this.listAlphabet = listAlphabet;
    }

    public void encryptText() throws IOException {
        System.out.println("Зашифруем с помощью ключа --->  ");
        while (streamReader.ready()) { // считываем байт из потока и кладём в String token.
            int b = streamReader.read();
            char ch = (char) b;
            String token = Character.toString(ch);

            for (int i = 0; i < listAlphabet.size(); i++) {  // цикл по элементам ArrayList listAlphabet.
                if (token.equals(listAlphabet.get(i))) {    // сравниваем каждый элемент listAlphabet с token (байтом из потока).
                    token = listAlphabet.get(i + 3); // если они равны, кодируем с помощью ключа +3.
                    outputStream.write(token.getBytes(StandardCharsets.UTF_8)); // выводим в файл "decrypt".
                    System.out.print(token);
                    break;
                }
            }
        }
    }

    public void decryptionOfTheText() throws IOException {
        System.out.println();
        System.out.println("Расшифруем с помощью ключа --->  ");

        while (streamReaderDecrypt.ready()) {  //считываем байт из потока и кладём в String token.
            int b = streamReaderDecrypt.read();
            char ch = (char) b;
            String token = Character.toString(ch);

            for (int i = 0; i < listAlphabet.size(); i++) { // цикл по элементам listAlphabet.
                if (token.equals(listAlphabet.get(i))) { // сравниваем каждый элемент listAlphabet с token (байтом из потока).
                    token = listAlphabet.get(i - 3); // если они одинаковые, раскодируем с помощью ключа -3.
                    System.out.print(token); // выводим на экран.
                    break;
                }
            }
        }
    }
}

