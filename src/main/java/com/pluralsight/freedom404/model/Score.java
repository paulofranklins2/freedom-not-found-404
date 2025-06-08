package com.pluralsight.freedom404.model;

import lombok.Data;

/**
 * Represents a player's score for a given puzzle.
 */
@Data
public class Score {
    private String username;
    private int puzzleId;
    private double completionTime; // seconds
    private int wrongAnswers;
}