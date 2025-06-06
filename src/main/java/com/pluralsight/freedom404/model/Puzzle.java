package com.pluralsight.freedom404.model;

public interface Puzzle {
    int getId();

    String getName();

    String getType();

    String getPrompt();

    String getAnswer();

    String getHint();

    String getRoomLabel();

    String getStoryIntro();

    String getConsequence();

    String getSuccessMessage();

    boolean checkAnswer(String input);
}
