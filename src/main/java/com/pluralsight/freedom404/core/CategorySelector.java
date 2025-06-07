package com.pluralsight.freedom404.core;

import com.pluralsight.freedom404.db.PuzzleDAO;
import com.pluralsight.freedom404.util.ConsolePrinter;
import com.pluralsight.freedom404.util.InputUtils;

import java.util.List;

public class CategorySelector {

    private final PuzzleDAO puzzleDAO;

    public CategorySelector(PuzzleDAO puzzleDAO) {
        this.puzzleDAO = puzzleDAO;
    }

    public String selectCategory() {
        List<String> categories = puzzleDAO.getAvailableCategories();

        while (true) {
            ConsolePrinter.lineBreak();
            ConsolePrinter.print(ConsolePrinter.center("Available Puzzle Categories"));
            ConsolePrinter.lineBreak();
            for (int i = 0; i < categories.size(); i++) {
                ConsolePrinter.print(String.format("%2d) %s", i + 1, categories.get(i)));
            }
            ConsolePrinter.lineBreak();

            int selectedIndex = InputUtils.promptInt("Choose Category: ") - 1;

            if (selectedIndex >= 0 && selectedIndex < categories.size()) {
                return categories.get(selectedIndex);
            }

            ConsolePrinter.printConsequence("Invalid selection. Please try again.");
        }
    }
}
