package com.pluralsight.freedom404.app;

import com.pluralsight.freedom404.core.CategorySelector;
import com.pluralsight.freedom404.core.PuzzleRunner;
import com.pluralsight.freedom404.db.PuzzleDAO;
import com.pluralsight.freedom404.model.Puzzle;
import com.pluralsight.freedom404.util.ConsolePrinter;
import com.pluralsight.freedom404.util.InputUtils;
import com.pluralsight.freedom404.db.ConfigLoader;

import java.util.List;

public class GameEngine {

    private final PuzzleDAO puzzleDAO = new PuzzleDAO();

    public void start() {
        ConsolePrinter.printTitle(ConfigLoader.get("game.title"));
        ConsolePrinter.print(ConsolePrinter.center("You wake up in a digital prison..."));
        InputUtils.pause("");

        CategorySelector selector = new CategorySelector(puzzleDAO);
        String chosenCategory = selector.selectCategory();

        if (chosenCategory == null) return;

        List<Puzzle> puzzles = puzzleDAO.getPuzzlesByCategory(chosenCategory);
        new PuzzleRunner(puzzles).run();
    }
}
