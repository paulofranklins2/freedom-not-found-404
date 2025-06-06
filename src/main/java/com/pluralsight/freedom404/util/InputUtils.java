package com.pluralsight.freedom404.util;

import java.util.Scanner;

public class InputUtils {

    private static final Scanner scanner = new Scanner(System.in);

    public static String prompt(String label) {
        System.out.print(label + ": ");
        return scanner.nextLine().trim();
    }

    public static int promptInt(String label) {
        while (true) {
            System.out.print(label);
            String input = scanner.nextLine();
            try {
                return Integer.parseInt(input.trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid number. Try again.");
            }
        }
    }

    public static void pause(String message) {
        if (message != null) {
            System.out.println(message);
        }
        System.out.print("Press ENTER to continue ");
        scanner.nextLine();
    }
}
