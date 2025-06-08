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
        if (top.isEmpty()) {
            return;
        }
        ConsolePrinter.printInfo("Top players:");
        for (int i = 0; i < top.size(); i++) {
            Score s = top.get(i);
            ConsolePrinter.print(String.format("%d. %s - %.2f sec, %d wrong",
                    i + 1, s.getUsername(), s.getCompletionTime(), s.getWrongAnswers()));
        }
    }
}