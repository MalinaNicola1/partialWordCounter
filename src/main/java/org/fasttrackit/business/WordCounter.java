package org.fasttrackit.business;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class WordCounter {
    private String sentences;
    private final List<String> wordsList;

    public WordCounter(String senteces) {
        this.sentences = senteces;
        wordsList = wordsDivider();
    }

    public int wordsCount() { //metoda pentru a ne returna numarul total de cuvinte
        return wordsList.size();
    }

    public int charactersCount() { //metoda pentru a ne returna numarul total de caractere diferite de caracterele albe
        int sum = 0;
        for (String word : wordsList)
            sum = sum + word.length();
        return sum;
    }

    public List<String> wordsDivider() { //metoda care divide textul in cuvinte
        // \s inseamna orice caracter alb(spatiu, tab, new line, etc), iar + este folosit in cazul in care exista mai multe astfel de caractere
        Pattern pattern = Pattern.compile("(?<!-)\\s+|(?<=\\S)[.,!?](?=\\s|$)");
        sentences = sentences.toLowerCase();

        //Stream-uri
        return Arrays.stream(pattern.split(sentences)) //Mai intai se 'sparge' in cuvinte bazat pe pattern-ul precizat (adica fara spatii albe)
                .filter(str -> !str.isEmpty()) //metoda filter() este folosita pentru a elimina oricare string-uri goale
                .collect(Collectors.toList()); //se colecteaza toata cuvintele obtinute si se salveaza intr-o lista List<String>
    }
}