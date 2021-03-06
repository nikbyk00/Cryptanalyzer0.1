package com.example.cryptanalyzer;

import java.util.ArrayList;

public class Alphabet {
    public static ArrayList<String> fillingWithSymbols(ArrayList<String> alphabet) {
        String[] first = {"а", "А", "б", "Б", "в", "В", "г", "Г", "д", "Д", "е",
                "Е", "ё", "Ё", "ж", "Ж", "з", "З", "и", "И", "й", "Й", "к", "К",
                "л", "Л", "м", "М", "н", "Н", "о", "О", "п", "П", "р", "Р", "с", "С",
                "т", "Т", "у", "У", "ф", "Ф", "х", "Х", "ц", "Ц", "ч", "Ч", "ш", "Ш",
                "щ", "Щ", "ъ", "Ъ", "ы", "Ы", "ь", "Ь", "э", "Э", "ю", "Ю", "я", "Я",
                ".", ",", "\"\"", ":", "-", "!", "?", " ", "(", ")", "@"};

        for (int i = 0; i < 77; i++) { // цикл для заполнения.
            alphabet.add(i, first[i]);
        }
        return alphabet;
    }
 /*
 Метод заполняет ArrayList символами,
 которые мы используем для кодировки.
 */
}