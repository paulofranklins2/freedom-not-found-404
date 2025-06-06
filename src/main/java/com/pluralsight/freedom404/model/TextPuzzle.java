package com.pluralsight.freedom404.model;

import lombok.Data;

@Data
public class TextPuzzle implements Puzzle {
    private int id;
    private String name;
    private String type;
    private String prompt;
    private String answer;
    private String hint;
    private String roomLabel;
    private String storyIntro;
    private String consequence;
    private String successMessage;

    @Override
    public boolean checkAnswer(String input) {
        return input != null && input.equalsIgnoreCase(answer);
    }
}
