package com.example.myfirstapp;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Dictionary {
    private List<String> dictionary;
    private int wordLength;
    private String word;

    public Dictionary(int wordLength) {
        this.dictionary = new ArrayList<>();
        this.wordLength = wordLength;
    }

    public List<String> getDictionary() {
        return dictionary;
    }

    public String getWord() {
        return word;
    }

    public void chooseWord() {
        Random random = new Random();
        word = dictionary.get(random.nextInt(dictionary.size()));
    }

    public void createList( List<String> words) {
        for (int i = 0; i < words.size(); i++) {
            if (words.get(i).length() == wordLength) {
                dictionary.add(words.get(i));
            }
        }
    }

    public void changeWord() {

    }
}
