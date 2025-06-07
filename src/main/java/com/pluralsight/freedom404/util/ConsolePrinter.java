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
