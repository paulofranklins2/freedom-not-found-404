package com.pluralsight.freedom404.app;

import com.pluralsight.freedom404.core.CategorySelector;
import com.pluralsight.freedom404.core.PuzzleRunner;
import com.pluralsight.freedom404.db.ConfigLoader;
import com.pluralsight.freedom404.db.PuzzleDAO;
import com.pluralsight.freedom404.db.ScoreDAO;
import com.pluralsight.freedom404.model.Puzzle;
import com.pluralsight.freedom404.model.Score;
import com.pluralsight.freedom404.util.ConsolePrinter;
import com.pluralsight.freedom404.util.InputUtils;

import java.util.List;

public class GameEngine {

    private final PuzzleDAO puzzleDAO = new PuzzleDAO();
    private final ScoreDAO scoreDAO = new ScoreDAO();

    public void start() {
        showIntro();
        String username = handleLogin();
        runGameLoop(username);
        ConsolePrinter.printTitle("Thanks for playing. Goodbye!");
    }

    private void showIntro() {
        ConsolePrinter.printTitle(ConfigLoader.get("game.title"));
        ConsolePrinter.print(ConsolePrinter.center("You wake up in a digital prison..."));
        InputUtils.pause("");
    }

    private String handleLogin() {
        String username = promptUsername();
        if (username != null) {
            boolean view = InputUtils.promptYesNo("View your saved scores? (yes/no)");
            if (view) {
                printUserScores(username);
            }
        }
        return username;
    }

    private void runGameLoop(String username) {
        boolean playAgain;
        do {
            CategorySelector selector = new CategorySelector(puzzleDAO);
            String chosenCategory = selector.selectCategory();

            if (chosenCategory == null) return;

            List<Puzzle> puzzles = puzzleDAO.getPuzzlesByCategory(chosenCategory);
            new PuzzleRunner(puzzles, username).run();

            playAgain = InputUtils.promptYesNo("Play again? (yes/no)");

        } while (playAgain);
    }

    private String promptUsername() {
        List<String> options = java.util.Arrays.asList(
                "Play as Guest",
                "Enter Username"
        );
        int choice = InputUtils.promptChoice("Select option", options);
        if (choice == 1) {
            return InputUtils.prompt("Username");
        }
        return null;
    }

    private void printUserScores(String username) {
        List<Score> scores = scoreDAO.getScoresByUser(username);
        if (scores.isEmpty()) {
            ConsolePrinter.printInfo("No scores found for " + username + ".");
            return;
        }
        ConsolePrinter.printInfo("Saved Scores:");
        for (Score s : scores) {
            Puzzle p = puzzleDAO.getPuzzleById(s.getPuzzleId());
            String label = (p != null) ? p.getRoomLabel() : "Puzzle " + s.getPuzzleId();
            ConsolePrinter.print(String.format("%s - %.2f sec, %d wrong", label, s.getCompletionTime(), s.getWrongAnswers()));
        }
        ConsolePrinter.lineBreak();
    }
}