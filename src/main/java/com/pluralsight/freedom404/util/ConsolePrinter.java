package com.pluralsight.freedom404.util;

public class ConsolePrinter {
    private static final int FORMATTING_WIDTH = 80;
    private static final int MAX_USERNAME_LENGTH = 20;

    /**
     * Build and print an ASCII table for the provided rows.
     */
    public static void printTable(String heading, String[] headers, java.util.List<String[]> rows) {
        printTable(heading, headers, rows, null);
    }

    /**
     * Build and print an ASCII table using supplied column widths.
     */
    public static void printTable(String heading, String[] headers, java.util.List<String[]> rows, int[] presetWidths) {
        printTitle(heading);

        int cols = headers.length;
        int[] widths = new int[cols];
        for (int i = 0; i < cols; i++) {
            widths[i] = headers[i].length();
        }
        for (String[] row : rows) {
            for (int i = 0; i < cols && i < row.length; i++) {
                if (row[i].length() > widths[i]) {
                    widths[i] = row[i].length();
                }
            }
        }
        if (presetWidths != null && presetWidths.length == cols) {
            for (int i = 0; i < cols; i++) {
                if (presetWidths[i] > widths[i]) {
                    widths[i] = presetWidths[i];
                }
            }
        }
        // Add a little padding to each column for readability
        for (int i = 0; i < cols; i++) {
            widths[i] += 2;
        }

        System.out.println(buildBorder('┌', '┬', '┐', widths));
        System.out.println(buildRow(headers, widths));
        System.out.println(buildBorder('├', '┼', '┤', widths));
        for (String[] row : rows) {
            System.out.println(buildRow(row, widths));
        }
        System.out.println(buildBorder('└', '┴', '┘', widths));
        lineBreak();
    }

    private static String buildRow(String[] cells, int[] widths) {
        StringBuilder sb = new StringBuilder();
        sb.append('│');
        for (int i = 0; i < widths.length; i++) {
            String cell = i < cells.length ? cells[i] : "";
            sb.append(padCenter(cell, widths[i]));
            sb.append('│');
        }
        return sb.toString();
    }

    private static String buildBorder(char start, char middle, char end, int[] widths) {
        StringBuilder sb = new StringBuilder();
        sb.append(start);
        for (int i = 0; i < widths.length; i++) {
            sb.append("─".repeat(widths[i]));
            sb.append(i == widths.length - 1 ? end : middle);
        }
        return sb.toString();
    }

    private static String padCenter(String text, int width) {
        if (text.length() >= width) {
            return text.substring(0, width);
        }
        int left = (width - text.length()) / 2;
        int right = width - text.length() - left;
        return " ".repeat(left) + text + " ".repeat(right);
    }

    public static String formatTime(double seconds) {
        int mins = (int) seconds / 60;
        int secs = (int) Math.round(seconds - mins * 60);
        return String.format("%02d:%02d", mins, secs);
    }

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
        String[] headers = {"POSITION", "USERNAME", "TIME", "WRONG ANSWERS"};
        java.util.List<String[]> rows = new java.util.ArrayList<>();
        for (int i = 0; i < scores.size(); i++) {
            com.pluralsight.freedom404.model.Score s = scores.get(i);
            String user = s.getUsername();
            if (user.length() > MAX_USERNAME_LENGTH) {
                user = user.substring(0, MAX_USERNAME_LENGTH);
            }
            rows.add(new String[]{
                    "#" + (i + 1),
                    user,
                    formatTime(s.getCompletionTime()),
                    String.valueOf(s.getWrongAnswers())
            });
        }

        int cols = headers.length;
        int totalWidth = FORMATTING_WIDTH - 8 - (cols + 1);
        int posW = Math.max(headers[0].length(), 10);
        int timeW = Math.max(headers[2].length(), 8);
        int wrongW = Math.max(headers[3].length(), 14);
        int userW = totalWidth - posW - timeW - wrongW;
        int[] widths = {posW, userW, timeW, wrongW};

        printTable(heading, headers, rows, widths);
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