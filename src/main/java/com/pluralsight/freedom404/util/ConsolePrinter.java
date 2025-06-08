package com.pluralsight.freedom404.util;

public class ConsolePrinter {
    private static final int FORMATTING_WIDTH = 80;

    public static void printTitle(String title) {
        lineBreak();
        System.out.println(ConsoleColors.BOLD + ConsoleColors.INFO + center(title.toUpperCase()) + ConsoleColors.RESET);
        lineBreak();
    }

    public static void print(String message) {
        System.out.println(ConsoleColors.INFO + message + ConsoleColors.RESET);
    }

    public static void printSuccess(String message) {
        System.out.println(ConsoleColors.RIGHT_ANSWER + "✔ " + message + ConsoleColors.RESET);
    }

    public static void printConsequence(String message) {
        System.out.println(ConsoleColors.WRONG_ANSWER + "✘ " + message + ConsoleColors.RESET);
    }

    public static void printHint(String message) {
        System.out.println(ConsoleColors.HINT + "Hint: " + message + ConsoleColors.RESET);
    }

    public static void printInfo(String message) {
        System.out.println(ConsoleColors.INFO + message + ConsoleColors.RESET);
    }

    public static void printQuestion(String message) {
        System.out.println(ConsoleColors.QUESTION + message + ConsoleColors.RESET);
    }

    /**
     * Prints a numbered menu based on the provided options.
     *
     * @param options list of option labels to display
     */
    public static void printMenu(java.util.List<String> options) {
        for (int i = 0; i < options.size(); i++) {
            System.out.printf("[%d] %s%n", i + 1, options.get(i));
        }
    }

    /**
     * Nicely formatted scoreboard output.
     */
    public static void printScoreboard(String heading, java.util.List<com.pluralsight.freedom404.model.Score> scores) {
        printTitle(heading);
        for (int i = 0; i < scores.size(); i++) {
            com.pluralsight.freedom404.model.Score s = scores.get(i);
            System.out.printf("%d. %-15s %7.2f sec %d wrong%n",
                    i + 1, s.getUsername(), s.getCompletionTime(), s.getWrongAnswers());
        }
        lineBreak();
    }

    public static void lineBreak() {
        System.out.println(ConsoleColors.INFO + "=".repeat(FORMATTING_WIDTH) + ConsoleColors.RESET);
    }

    public static String center(String text) {
        int totalPadding = FORMATTING_WIDTH - text.length();
        if (totalPadding <= 0) return text;
        int left = totalPadding / 2;
        int right = totalPadding - left;
        return " ".repeat(left) + text + " ".repeat(right);
    }
}
