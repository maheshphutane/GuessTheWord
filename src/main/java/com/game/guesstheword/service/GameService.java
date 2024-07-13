package com.game.guesstheword.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@Scope("prototype")
public class GameService {
    private final String[] words = {"apple", "banana", "cherry", "date", "elderberry", "fig", "grape", "honeydew", "kiwi", "lemon", "mango", "nectarine", "orange", "papaya", "quince", "raspberry", "strawberry", "tangerine", "ugli", "vanilla", "watermelon", "yellow"};
    Random random = new Random();
    private String randomWord;
    private char[] randomWordArray;
    public GameService() {
        randomWord = words[random.nextInt(words.length)];
        System.out.println(randomWord);
        randomWordArray = new char[randomWord.length()];
    }
    public String getWord(){
        String word = "";
        for (int i = 0; i < randomWordArray.length; i++) {
            if(randomWordArray[i] == '\u0000')
                word += "_";
            else
                word += randomWordArray[i];
            word+=" ";
        }
        return word;
    }

    public boolean addGuess(char c) {
        boolean isCorrectGuess = false;
        for (int i = 0; i < randomWord.length(); i++) {
            if(randomWord.charAt(i) == c){
                randomWordArray[i] = c;
                isCorrectGuess = true;
            }
        }
        return isCorrectGuess;
    }
}
