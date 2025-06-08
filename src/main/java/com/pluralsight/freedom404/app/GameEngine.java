package com.pluralsight.freedom404.app;

import com.pluralsight.freedom404.core.CategorySelector;
import com.pluralsight.freedom404.core.PuzzleRunner;
import com.pluralsight.freedom404.core.ScoreService;
import com.pluralsight.freedom404.db.ConfigLoader;
import com.pluralsight.freedom404.db.PuzzleDAO;
import com.pluralsight.freedom404.model.Puzzle;
import com.pluralsight.freedom404.util.ConsolePrinter;
import com.pluralsight.freedom404.util.InputUtils;

import java.util.List;

public class GameEngine {

    private final PuzzleDAO puzzleDAO = new PuzzleDAO();
    private final ScoreService scoreService = new ScoreService();

    public void start() {
        showIntro();
        String username = handleInitialMenu();
        runGameLoop(username);
        ConsolePrinter.printTitle("Thanks for playing. Goodbye!");
    }

    private void showIntro() {
        ConsolePrinter.printTitle(ConfigLoader.get("game.title"));
        ConsolePrinter.print(ConsolePrinter.center("You wake up in a digital prison..."));
        InputUtils.pause("");
    }

    private String handleInitialMenu() {
        while (true) {
            int choice = InputUtils.promptChoice("Select option", java.util.Arrays.asList(
                    "Play as Guest",
                    "Enter Username",
                    "View Global Scores"));

            if (choice == 0) {
                return null;
            } else if (choice == 1) {
                String username = InputUtils.prompt("Username");
                boolean view = InputUtils.promptYesNo("View your saved scores? (yes/no)");
                if (view) {
                    scoreService.printUserScores(username, puzzleDAO);
                }
                return username;
            } else if (choice == 2) {
                scoreService.printGlobalLeaderboard(puzzleDAO.getAvailableCategories());
            }
        }
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
}
