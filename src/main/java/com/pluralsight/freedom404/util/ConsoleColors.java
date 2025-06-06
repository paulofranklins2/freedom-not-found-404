package com.pluralsight.freedom404.util;

public class ConsoleColors {
    public static final String RESET = "\u001B[0m";

    // Regular Colors
    public static final String BLACK = "\u001B[30m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String WHITE = "\u001B[37m";

    public static final String BOLD = "\033[1m";

    // Semantic aliases
    public static final String RIGHT_ANSWER = GREEN;
    public static final String WRONG_ANSWER = RED;
    public static final String HINT = YELLOW;
    public static final String PROMPT = CYAN;
    public static final String INFO = BLUE;
    public static final String QUESTION = PURPLE;
}
