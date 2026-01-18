package com.bankapp.presentation.input;

import com.bankapp.model.Gender;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class ConsoleReader {

    private static final Scanner SCANNER = new Scanner(System.in);

    private ConsoleReader() {
        // Utility class
    }

    // --------------------------------------------------
    public static String readString() {
        return SCANNER.nextLine().trim();
    }

    // --------------------------------------------------
    public static int readInt() {
        while (true) {
            String input = readString();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.print("Invalid number. Please enter a valid integer: ");
            }
        }
    }

    // --------------------------------------------------
    public static long readLong() {
        while (true) {
            String input = readString();
            try {
                return Long.parseLong(input);
            } catch (NumberFormatException e) {
                System.out.print("Invalid number. Please enter a valid long value: ");
            }
        }
    }

    // --------------------------------------------------
    public static double readDouble() {
        while (true) {
            String input = readString();
            try {
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.print("Invalid number. Please enter a valid decimal value: ");
            }
        }
    }

    // --------------------------------------------------
    public static boolean readYesNo() {
        while (true) {
            String input = readString().toLowerCase();
            if (input.equals("y") || input.equals("yes")) {
                return true;
            }
            if (input.equals("n") || input.equals("no")) {
                return false;
            }
            System.out.print("Please enter yes or no (y/n): ");
        }
    }

    // --------------------------------------------------
    public static BigDecimal readBigDecimal() {
        while (true) {
            String input = readString();
            try {
                return new BigDecimal(input);
            } catch (NumberFormatException e) {
                System.out.print("Invalid amount. Please enter a valid decimal number: ");
            }
        }
    }

    // --------------------------------------------------
    public static LocalDate readLocalDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        while (true) {
            String input = readString();
            try {
                return LocalDate.parse(input, formatter);
            } catch (DateTimeParseException e) {
                System.out.print("Invalid date. Please enter date in yyyy-MM-dd format: ");
            }
        }
    }

    // --------------------------------------------------
    public static Gender readGender() {
        while (true) {
            String input = readString().trim().toUpperCase();

            try {
                return Gender.valueOf(input);
            } catch (IllegalArgumentException e) {
                System.out.print("Invalid gender. Please enter MALE, FEMALE, or OTHER: ");
            }
        }
    }



}
