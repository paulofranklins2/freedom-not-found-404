package com.pluralsight.freedom404.util;

import java.util.Scanner;

// For colored console prompts
import com.pluralsight.freedom404.util.ConsoleColors;

public class InputUtils {

    private static final Scanner scanner = new Scanner(System.in);

    public static String prompt(String label) {
        System.out.print(ConsoleColors.PROMPT + label + ": " + ConsoleColors.RESET);
        return scanner.nextLine().trim();
    }

    public static int promptInt(String label) {
        while (true) {
            System.out.print(ConsoleColors.PROMPT + label + ConsoleColors.RESET);
            String input = scanner.nextLine();
            try {
                return Integer.parseInt(input.trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid number. Try again.");
            }
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
