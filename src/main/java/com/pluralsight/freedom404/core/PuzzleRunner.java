package com.pluralsight.freedom404.core;

import com.pluralsight.freedom404.db.ConfigLoader;
import com.pluralsight.freedom404.model.Puzzle;
import com.pluralsight.freedom404.util.ConsolePrinter;
import com.pluralsight.freedom404.util.InputUtils;

import java.util.List;

public class PuzzleRunner {

    private final List<Puzzle> puzzles;
    private final String username;
    private int wrongAttempts;
    private final ScoreService scoreService = new ScoreService();

    public PuzzleRunner(List<Puzzle> puzzles, String username) {
        this.puzzles = puzzles;
        this.username = username;
    }

    public void run() {
        for (Puzzle puzzle : puzzles) {
            presentPuzzle(puzzle);

            if (!solvePuzzle(puzzle)) {
                ConsolePrinter.lineBreak();
                ConsolePrinter.printConsequence("You failed too many times. You're staying here forever...");
                return;
            }
        }

        ConsolePrinter.printTitle("Congratulations, you escaped the digital trap!");
    }

    private void presentPuzzle(Puzzle puzzle) {
        ConsolePrinter.lineBreak();
        ConsolePrinter.print(ConsolePrinter.center("Entering: " + puzzle.getRoomLabel()));
        ConsolePrinter.printInfo(ConsolePrinter.center(puzzle.getStoryIntro()));
        ConsolePrinter.printQuestion(ConsolePrinter.center(puzzle.getPrompt()));
    }

    private boolean solvePuzzle(Puzzle puzzle) {
        int attemptsForPuzzle = 0;
        long start = System.currentTimeMillis();
        while (true) {
            String input = InputUtils.prompt("Answer");

            if (puzzle.checkAnswer(input)) {
                handleCorrectAnswer(puzzle, attemptsForPuzzle, start);
                return true;
            }

            attemptsForPuzzle++;
            wrongAttempts++;
            handleWrongAnswer(puzzle);

            if (wrongAttempts >= Integer.parseInt(ConfigLoader.get("max.retries"))) return false;
        }
    }

    private void handleCorrectAnswer(Puzzle puzzle, int attemptsForPuzzle, long start) {
        ConsolePrinter.printSuccess(puzzle.getSuccessMessage());
        if (username != null) {
            scoreService.recordScore(username, puzzle, attemptsForPuzzle, System.currentTimeMillis() - start);
            scoreService.printBestScore(username, puzzle.getId());
            scoreService.printLeaderboard(puzzle);
        }
    }

    private void handleWrongAnswer(Puzzle puzzle) {
        ConsolePrinter.printConsequence(puzzle.getConsequence());
        ConsolePrinter.printHint(puzzle.getHint());
    }
}