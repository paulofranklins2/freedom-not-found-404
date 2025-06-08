package com.pluralsight.freedom404.db;

import com.pluralsight.freedom404.model.Puzzle;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public abstract class AbstractPuzzleRepository {

    protected List<Puzzle> puzzles;

    public List<String> getAvailableCategories() {
        return puzzles.stream()
                .map(p -> {
                    String label = p.getRoomLabel();
                    int index = label.lastIndexOf(" Room ");
                    return (index != -1) ? label.substring(0, index) : label;
                })
                .distinct()
                .sorted()
                .collect(Collectors.toList());
    }

    public List<Puzzle> getPuzzlesByCategory(String category) {
        return puzzles.stream()
                .filter(p -> p.getRoomLabel().startsWith(category + " Room"))
                .sorted(Comparator.comparing(Puzzle::getRoomLabel))
                .collect(Collectors.toList());
    }

    public Puzzle getPuzzleById(int id) {
        for (Puzzle p : puzzles) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }
}