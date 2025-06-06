package com.pluralsight.freedom404.model;

public interface Puzzle {
    String getName();
    String getPrompt();
    boolean checkAnswer(String input);
}
