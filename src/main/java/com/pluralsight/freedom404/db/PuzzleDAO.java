package com.pluralsight.freedom404.db;

import com.pluralsight.freedom404.model.Puzzle;
import com.pluralsight.freedom404.model.TextPuzzle;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PuzzleDAO extends AbstractPuzzleRepository {

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
}
