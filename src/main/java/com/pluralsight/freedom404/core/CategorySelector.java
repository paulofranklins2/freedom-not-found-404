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
            ConsolePrinter.print(ConsolePrinter.center("Available Puzzle Categories:"));
            int selectedIndex = InputUtils.promptChoice("Choose Category", categories);

            if (selectedIndex >= 0 && selectedIndex < categories.size()) {
                return categories.get(selectedIndex);
            }
        }
    }
}
