package com.pluralsight.freedom404.core;

import com.pluralsight.freedom404.db.ConfigLoader;
import com.pluralsight.freedom404.model.Puzzle;
import com.pluralsight.freedom404.model.Score;
import com.pluralsight.freedom404.db.ScoreDAO;
import com.pluralsight.freedom404.util.ConsolePrinter;
import com.pluralsight.freedom404.util.InputUtils;

import java.util.List;

public class PuzzleRunner {

    private final List<Puzzle> puzzles;
    private final String username;
    private int wrongAttempts;
    private final ScoreDAO scoreDAO = new ScoreDAO();

    public PuzzleRunner(List<Puzzle> puzzles, String username) {
        this.puzzles = puzzles;
        this.username = username;
    }

    public void startGameLoop() {
        boolean playAgain;

        do {
            wrongAttempts = 0;
            run();

            playAgain = InputUtils.promptYesNo("Play again? (yes/no)");

        } while (playAgain);

        ConsolePrinter.printTitle("Thanks for playing. Goodbye!");
    }

    public void run() {
        for (Puzzle puzzle : puzzles) {
            ConsolePrinter.lineBreak();
            ConsolePrinter.print(ConsolePrinter.center("Entering: " + puzzle.getRoomLabel()));
            ConsolePrinter.printInfo(ConsolePrinter.center(puzzle.getStoryIntro()));
            ConsolePrinter.printQuestion(ConsolePrinter.center(puzzle.getPrompt()));

            if (!solvePuzzle(puzzle)) {
                ConsolePrinter.lineBreak();
                ConsolePrinter.printConsequence("You failed too many times. You're staying here forever...");
                return;
            }
        }

        ConsolePrinter.printTitle("Congratulations, you escaped the digital trap!");
    }

    private boolean solvePuzzle(Puzzle puzzle) {
        int attemptsForPuzzle = 0;
        long start = System.currentTimeMillis();
        while (true) {
            String input = InputUtils.prompt("Answer");

            if (puzzle.checkAnswer(input)) {
                ConsolePrinter.printSuccess(puzzle.getSuccessMessage());

                if (username != null) {
                    Score score = new Score();
                    score.setUsername(username);
                    score.setPuzzleId(puzzle.getId());
                    score.setCompletionTime((System.currentTimeMillis() - start) / 1000.0);
                    score.setWrongAnswers(attemptsForPuzzle);
                    scoreDAO.upsertScore(score);

                    Score best = scoreDAO.getBestScore(username, puzzle.getId());
                    if (best != null) {
                        ConsolePrinter.printInfo(String.format("Best score: %.2f sec, %d wrong answers", best.getCompletionTime(), best.getWrongAnswers()));
                    }

                    printLeaderboard(puzzle);
                }

                return true;
            }

            attemptsForPuzzle++;
            wrongAttempts++;
            ConsolePrinter.printConsequence(puzzle.getConsequence());
            ConsolePrinter.printHint(puzzle.getHint());

            if (wrongAttempts >= Integer.parseInt(ConfigLoader.get("max.retries"))) return false;
        }
    }

    private void printLeaderboard(Puzzle puzzle) {
        List<Score> top = scoreDAO.getLeaderboard(puzzle.getId(), 5);
        if (top.isEmpty()) {
            return;
        }
        ConsolePrinter.printInfo("Top players:");
        for (int i = 0; i < top.size(); i++) {
            Score s = top.get(i);
            ConsolePrinter.print(String.format("%d. %s - %.2f sec, %d wrong", i + 1, s.getUsername(), s.getCompletionTime(), s.getWrongAnswers()));
        }
    }
}