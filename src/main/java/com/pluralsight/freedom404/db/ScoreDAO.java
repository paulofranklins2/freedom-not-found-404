package com.pluralsight.freedom404.db;

import com.pluralsight.freedom404.model.Score;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Data access object for managing player scores.
 */
public class ScoreDAO {

    /**
     * Insert or update a player's score for a puzzle. If a record already exists
     * for the given username and puzzle, each field is updated only if the new
     * value is better (smaller). This prevents worse times or higher wrong
     * answer counts from overwriting a player's previous best.
     */
    public void upsertScore(Score score) {
        String sql = "INSERT INTO scores (username, puzzle_id, completion_time, wrong_answers) " +
                "VALUES (?, ?, ?, ?) " +
                "ON DUPLICATE KEY UPDATE " +
                "completion_time = LEAST(completion_time, VALUES(completion_time)), " +
                "wrong_answers   = LEAST(wrong_answers, VALUES(wrong_answers))";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, score.getUsername());
            stmt.setInt(2, score.getPuzzleId());
            stmt.setDouble(3, score.getCompletionTime());
            stmt.setInt(4, score.getWrongAnswers());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error upserting score: " + e.getMessage());
        }
    }

    /**
     * Retrieve the best score for a player on a specific puzzle.
     */
    public Score getBestScore(String username, int puzzleId) {
        String sql = "SELECT * FROM scores WHERE username = ? AND puzzle_id = ?";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, username);
            stmt.setInt(2, puzzleId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Score score = new Score();
                    score.setUsername(rs.getString("username"));
                    score.setPuzzleId(rs.getInt("puzzle_id"));
                    score.setCompletionTime(rs.getDouble("completion_time"));
                    score.setWrongAnswers(rs.getInt("wrong_answers"));
                    return score;
                }
            }
        } catch (SQLException e) {
            System.err.println("Error retrieving best score: " + e.getMessage());
        }
        return null;
    }

    /**
     * Retrieve all scores for a given user.
     */
    public List<Score> getScoresByUser(String username) {
        String sql = "SELECT * FROM scores WHERE username = ? ORDER BY puzzle_id";
        List<Score> scores = new ArrayList<>();
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, username);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Score score = new Score();
                    score.setUsername(rs.getString("username"));
                    score.setPuzzleId(rs.getInt("puzzle_id"));
                    score.setCompletionTime(rs.getDouble("completion_time"));
                    score.setWrongAnswers(rs.getInt("wrong_answers"));
                    scores.add(score);
                }
            }
        } catch (SQLException e) {
            System.err.println("Error retrieving scores: " + e.getMessage());
        }
        return scores;
    }

    /**
     * Retrieve a leaderboard for a puzzle ordered by best completion time and fewest wrong answers.
     */
    public List<Score> getLeaderboard(int puzzleId, int limit) {
        String sql = "SELECT * FROM scores WHERE puzzle_id = ? " +
                "ORDER BY completion_time ASC, wrong_answers ASC LIMIT ?";
        List<Score> scores = new ArrayList<>();
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, puzzleId);
            stmt.setInt(2, limit);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Score score = new Score();
                    score.setUsername(rs.getString("username"));
                    score.setPuzzleId(rs.getInt("puzzle_id"));
                    score.setCompletionTime(rs.getDouble("completion_time"));
                    score.setWrongAnswers(rs.getInt("wrong_answers"));
                    scores.add(score);
                }
            }
        } catch (SQLException e) {
            System.err.println("Error retrieving leaderboard: " + e.getMessage());
        }
        return scores;
    }
}