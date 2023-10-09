package org.fasttrackit;
import org.fasttrackit.business.WordCounter;

public class Main {
    public static void main(String[] args) {
        WordCounter wordCounter = new WordCounter("Acesta este un mesaj de verificare.");
        System.out.println(wordCounter.wordsCount());
        System.out.println(wordCounter.charactersCount());
        System.out.println(wordCounter.wordsDivider());
    }
}
