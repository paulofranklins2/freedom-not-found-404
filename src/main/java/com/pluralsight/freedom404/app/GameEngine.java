package com.pluralsight.freedom404.app;

import com.pluralsight.freedom404.db.ConfigLoader;
import com.pluralsight.freedom404.db.PuzzleDAO;
import com.pluralsight.freedom404.model.Puzzle;
import com.pluralsight.freedom404.util.ConsolePrinter;
import com.pluralsight.freedom404.util.InputUtils;

import java.util.List;

public class GameEngine {

    private final PuzzleDAO puzzleDAO = new PuzzleDAO();

    public void start() {
        ConsolePrinter.printTitle(ConfigLoader.get("game.title"));
//        ConsolePrinter.printTitle("FYou wake up in a digital prison");

        InputUtils.pause("You wake up in a digital prison");

        List<String> availableCategories = puzzleDAO.getAvailableCategories();

        ConsolePrinter.printWithBorder("Available Puzzle Categories:");
        for (int i = 0; i < availableCategories.size(); i++) {
            System.out.printf("[%d] %s%n", i + 1, availableCategories.get(i));
        }

        int selectedIndex = InputUtils.promptInt("Chose Category: ") - 1;

        if (selectedIndex < 0 || selectedIndex >= availableCategories.size()) {
            ConsolePrinter.printConsequence("Invalid selection. Game terminated.");
            return;
        }

        String selectedCategory = availableCategories.get(selectedIndex);
        List<Puzzle> puzzles = puzzleDAO.getPuzzlesByCategory(selectedCategory);

        int wrongAttempts = 0;

        for (Puzzle puzzle : puzzles) {
            ConsolePrinter.lineBreak();
            ConsolePrinter.printWithBorder("Entering: " + puzzle.getRoomLabel());
            ConsolePrinter.printInfo(puzzle.getStoryIntro());

            ConsolePrinter.printQuestion(puzzle.getPrompt());

            boolean solved = false;
            while (!solved) {
                String input = InputUtils.prompt("Your answer");

                if (puzzle.checkAnswer(input)) {
                    ConsolePrinter.printSuccess(puzzle.getSuccessMessage());
                    solved = true;
                } else {
                    wrongAttempts++;
                    ConsolePrinter.printConsequence(puzzle.getConsequence());
                    ConsolePrinter.printHint(puzzle.getHint());

                    if (wrongAttempts >= 3) {
                        ConsolePrinter.lineBreak();
                        ConsolePrinter.printConsequence("You failed too many times. You're staying here forever...");
                        return;
                    }
                }
            }
        }

        ConsolePrinter.printTitle("Congratulations, you escaped the digital trap!");
    }
}
