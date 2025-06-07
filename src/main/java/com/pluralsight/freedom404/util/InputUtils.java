package com.pluralsight.freedom404.util;

import java.util.Scanner;

import com.pluralsight.freedom404.util.ConsoleColors;
import com.pluralsight.freedom404.util.ConsolePrinter;
import java.util.List;

/**
 * Utility methods for interacting with the user via the console.
 * This class centralizes input logic to keep prompts consistent
 * across the application.
 */

public class InputUtils {

    private static final Scanner scanner = new Scanner(System.in);

    /**
     * Prompts the user for a line of input.
     *
     * @param label text displayed before the prompt
     * @return trimmed user input
     */
    public static String prompt(String label) {
        System.out.print(ConsoleColors.PROMPT + label + ": " + ConsoleColors.RESET);
        return scanner.nextLine().trim();
    }

    /**
     * Continuously prompts until the user provides a valid integer.
     */
    public static int promptInt(String label) {
        while (true) {
            String input = prompt(label);
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid number. Try again.");
            }
        }
    }

    /**
     * Displays a numbered list of options and prompts the user to pick one.
     *
     * @param label   prompt shown to the user
     * @param options available option labels
     * @return zero-based index of the chosen option
     */
    public static int promptChoice(String label, List<String> options) {
        while (true) {
            ConsolePrinter.printMenu(options);
            int idx = promptInt(label) - 1;
            if (idx >= 0 && idx < options.size()) return idx;
            ConsolePrinter.printConsequence("Invalid selection. Please try again.");
        }
    }

    /**
     * Prompts the user with a yes/no question and returns the boolean result.
     * Accepts "y"/"yes" and "n"/"no" (case insensitive).
     */
    public static boolean promptYesNo(String label) {
        while (true) {
            String input = prompt(label).toLowerCase();
            if (input.equals("y") || input.equals("yes")) return true;
            if (input.equals("n") || input.equals("no")) return false;
            System.out.println("Please enter yes or no.");
        }
    }

    public static void pause(String message) {
        if (!message.isBlank()) {
            System.out.println(message);
        }
        System.out.print(ConsoleColors.PROMPT + "Press ENTER to continue " + ConsoleColors.RESET);
        scanner.nextLine();
    }
}
