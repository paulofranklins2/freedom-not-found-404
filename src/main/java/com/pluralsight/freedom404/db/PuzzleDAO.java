package com.pluralsight.freedom404.db;

import com.pluralsight.freedom404.model.Puzzle;
import com.pluralsight.freedom404.model.TextPuzzle;

import java.sql.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class PuzzleDAO {
    private List<Puzzle> puzzles;

    public PuzzleDAO() {
        this.puzzles = loadAllPuzzles();
    }

    private List<Puzzle> loadAllPuzzles() {
        List<Puzzle> puzzles = new ArrayList<>();
        String sql = "SELECT * FROM puzzles";

        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                TextPuzzle puzzle = new TextPuzzle();
                puzzle.setId(rs.getInt("id"));
                puzzle.setName(rs.getString("name"));
                puzzle.setType(rs.getString("type"));
                puzzle.setPrompt(rs.getString("prompt"));
                puzzle.setAnswer(rs.getString("answer"));
                puzzle.setHint(rs.getString("hint"));
                puzzle.setRoomLabel(rs.getString("room_label"));
                puzzle.setStoryIntro(rs.getString("story_intro"));
                puzzle.setConsequence(rs.getString("consequence"));
                puzzle.setSuccessMessage(rs.getString("success_message"));

                puzzles.add(puzzle);
            }

        } catch (SQLException e) {
            System.err.println("Error loading puzzles: " + e.getMessage());
        }

        return puzzles;
    }

    public List<Puzzle> getPuzzlesByRoom(String roomLabel) {
        return puzzles.stream()
                .filter(p -> p.getRoomLabel().equalsIgnoreCase(roomLabel))
                .collect(Collectors.toList());
    }

    public List<String> getAvailableRooms() {
        return puzzles.stream()
                .map(Puzzle::getRoomLabel)
                .distinct()
                .sorted()
                .collect(Collectors.toList());
    }

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
}

