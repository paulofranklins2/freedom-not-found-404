package com.pluralsight.freedom404.core;

import com.pluralsight.freedom404.db.ScoreDAO;
import com.pluralsight.freedom404.model.Puzzle;
import com.pluralsight.freedom404.model.Score;
import com.pluralsight.freedom404.util.ConsolePrinter;

import java.util.List;

/**
 * Handles storing and displaying player scores.
 */
public class ScoreService {

    private final ScoreDAO scoreDAO = new ScoreDAO();

    public void recordScore(String username, Puzzle puzzle, int wrongAttempts, long durationMs) {
        Score score = new Score();
        score.setUsername(username);
        score.setPuzzleId(puzzle.getId());
        score.setCompletionTime(durationMs / 1000.0);
        score.setWrongAnswers(wrongAttempts);
        scoreDAO.upsertScore(score);
    }

    public void printBestScore(String username, int puzzleId) {
        Score best = scoreDAO.getBestScore(username, puzzleId);
        if (best != null) {
            ConsolePrinter.printInfo(String.format(
                    "Best score: %.2f sec, %d wrong answers",
                    best.getCompletionTime(), best.getWrongAnswers()));
        }
    }

    public void printLeaderboard(Puzzle puzzle) {
        List<Score> top = scoreDAO.getLeaderboard(puzzle.getId(), 5);
        if (!top.isEmpty()) {
            ConsolePrinter.printScoreboard("Top players", top);
        }
    }

    public void printUserScores(String username, com.pluralsight.freedom404.db.PuzzleDAO puzzleDAO) {
        List<Score> scores = scoreDAO.getScoresByUser(username);
        if (scores.isEmpty()) {
            ConsolePrinter.printInfo("No scores found for " + username + ".");
            return;
        }
        java.util.List<String[]> rows = new java.util.ArrayList<>();
        for (int i = 0; i < scores.size(); i++) {
            Score s = scores.get(i);
            Puzzle p = puzzleDAO.getPuzzleById(s.getPuzzleId());
            String label = (p != null) ? p.getRoomLabel() : "Puzzle " + s.getPuzzleId();
            rows.add(new String[]{
                    "#" + (i + 1),
                    label,
                    ConsolePrinter.formatTime(s.getCompletionTime()),
                    String.valueOf(s.getWrongAnswers())
            });
        }
        String[] headers = {"POSITION", "PUZZLE", "TIME", "WRONG ANSWERS"};
        ConsolePrinter.printTable(username + "'s Scores", headers, rows);
    }

    /**
     * Display the top players for each puzzle theme using aggregated times.
     */
    public void printGlobalLeaderboard(java.util.List<String> categories) {
        ConsolePrinter.printTitle("Global Scores");
        for (String category : categories) {
            List<Score> top = scoreDAO.getCategoryLeaderboard(category, 5);
            if (!top.isEmpty()) {
                ConsolePrinter.printScoreboard(category, top);
            }
        }
    }
}