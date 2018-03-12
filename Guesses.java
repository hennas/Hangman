package com.example.myfirstapp;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class Guesses {
    private List<String> guessedLetters;
    private List<String> word;
    private String[] revealedWord;
    private int numOfGuesses;

    public Guesses(String word, int numOfGuesses) {
        this.guessedLetters = new ArrayList<>();
        this.word = new ArrayList<>();
        String[] wordParts = word.split("");
        for (int i = 1; i < wordParts.length; i++) {
            this.word.add(wordParts[i]);
        }
        this.revealedWord = new String[word.length()];
        this.numOfGuesses = numOfGuesses;
    }

    public String[] getRevealedWord() {
        return revealedWord;
    }

    public void checkGuessed(String guessed) {
        numOfGuesses--;
        guessedLetters.add(guessed);
        for (int i = 0; i < word.size(); i++) {
            if (word.get(i).equals(guessed)) {
                revealedWord[i] = guessed;
            }
        }
    }

    public boolean gameEnded() {
        if (numOfGuesses > 0) {
            return true;
        }
        return false;
    }
}
