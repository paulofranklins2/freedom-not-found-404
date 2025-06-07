package com.pluralsight.freedom404.core;

import com.pluralsight.freedom404.db.ConfigLoader;
import com.pluralsight.freedom404.model.Puzzle;
import com.pluralsight.freedom404.util.ConsolePrinter;
import com.pluralsight.freedom404.util.InputUtils;

import java.util.List;

public class PuzzleRunner {

    private final List<Puzzle> puzzles;
    private int wrongAttempts;

    public PuzzleRunner(List<Puzzle> puzzles) {
        this.puzzles = puzzles;
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
        while (true) {
            String input = InputUtils.prompt("Answer");

            if (puzzle.checkAnswer(input)) {
                ConsolePrinter.printSuccess(puzzle.getSuccessMessage());
                return true;
            }

            wrongAttempts++;
            ConsolePrinter.printConsequence(puzzle.getConsequence());
            ConsolePrinter.printHint(puzzle.getHint());

            if (wrongAttempts >= Integer.parseInt(ConfigLoader.get("max.retries"))) return false;
        }
    }
}
