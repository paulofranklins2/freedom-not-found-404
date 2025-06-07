package com.pluralsight.freedom404.util;

public class ConsolePrinter {
    private static final int formatingSize = 100;

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

    public static void lineBreak() {
        System.out.println(ConsoleColors.INFO + "-".repeat(formatingSize) + ConsoleColors.RESET);
    }

    public static String center(String text) {
        int padding = (formatingSize - text.length()) / 2;
        return " ".repeat(Math.max(0, padding)) + text;
    }
}
