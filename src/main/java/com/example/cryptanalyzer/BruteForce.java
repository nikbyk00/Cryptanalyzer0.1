package com.example.cryptanalyzer;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class BruteForce {
    public static void decodingBruteForce() {

        try (
                FileInputStream inputStream = new FileInputStream("decrypt");
                InputStreamReader streamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8); // считываем с файла зашифрванный текст.
        ) {
            ArrayList<String> listAlphabet = new ArrayList<>();
            ArrayList<String> listStream = new ArrayList<>();
            Alphabet.fillingWithSymbols(listAlphabet); // заполняем Array List значениями из Алфавита.
            System.out.println();
            System.out.println("Brute force ---> ");

            while (streamReader.ready()) { //считываем байт из потока и кладём в listStream.
                int b = streamReader.read();
                char ch = (char) b;
                String token = Character.toString(ch);
                listStream.add(token);
            }
            for (int key = 0; key < 10; key++) {  // цикл для подбора ключа.
                System.out.print(" Ключ " + key + " ---> ");
                for (int i = 0; i < listStream.size(); i++) {  //цикл по элементам ArrayList listStream.
                    String element = listStream.get(i);  //помещаем элемент с индексом i в element.
                    for (int j = 0; j < listAlphabet.size(); j++) { //цикл по элементам ArrayList listAlphabet.
                        if(element.equals(listAlphabet.get(j))){  //сравниваем каждый элемент listAlphabet с element.
                            element = listAlphabet.get(j - key);  //если они одинаковые, раскодируем с помощью ключа k
                            System.out.print(element);
                            break;
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IndexOutOfBoundsException e){
            System.out.print(" <--- stop ");
        }
    }
}