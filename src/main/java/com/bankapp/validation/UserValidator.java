package com.bankapp.validation;

import com.bankapp.model.Gender;
import com.bankapp.model.Role;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class UserValidator {

    private UserValidator () {  }

    public static boolean isValidUserId(String userIdStr) {
        if (userIdStr == null || userIdStr.trim().isEmpty()) {
            return false;
        }

        try {
            long userId = Long.parseLong(userIdStr);
            return userId > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isValidUsername(String username) {
        if (username ==  null) {
            return false;
        }

        username = username.trim();

        if (username.isEmpty()) {
            return false;
        }

        if (username.length() < 3 || username.length() > 20) {
            return false;
        }

        return username.matches("^[a-zA-Z0-9._]+$");
    }

    public static boolean isValidPassword(String password) {
        if (password == null) {
            return false;
        }

        password = password.trim();

        if (password.isEmpty()) {
            return false;
        }

        if (password.length() < 8 || password.length() > 64) {
            return false;
        }

        boolean hasLetter = false;
        boolean hasDigit = false;

        for (char c : password.toCharArray()) {
            if (Character.isLetter(c)) {
                hasLetter = true;
            } else if (Character.isDigit(c)) {
                hasDigit = true;
            }

            if (hasLetter && hasDigit) {
                return true;
            }
        }

        return false;
    }

    public static boolean isValidName(String name) {
        if (name == null) {
            return false;
        }

        name = name.trim();

        if (name.isEmpty()) {
            return false;
        }

        if (name.length() < 2 || name.length() > 50) {
            return false;
        }

        return name.matches("^[A-Za-z ]+$");
    }

    public static boolean isValidDateOfBirth(String dobStr) {
        if (dobStr == null) {
            return false;
        }

        dobStr =  dobStr.trim();

        if (dobStr.isEmpty()) {
            return false;
        }

        try {
            LocalDate dob =  LocalDate.parse(dobStr);
            return dob.isBefore(LocalDate.now().minusYears(18));
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    public static boolean isValidGender(String genderStr) {
        if (genderStr == null) {
            return false;
        }

        genderStr = genderStr.trim().toUpperCase();

        if (genderStr.isEmpty()) {
            return false;
        }

        try {
            Gender.valueOf(genderStr);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    public static boolean isValidEmail(String email) {
        if (email == null) {
            return false;
        }

        email = email.trim();

        if (email.isEmpty()) {
            return false;
        }

        return email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
    }

    public static boolean isValidNationality(String nationality) {
        if (nationality == null) {
            return false;
        }

        nationality = nationality.trim();

        if (nationality.isEmpty()) {
            return false;
        }

        return nationality.matches("^[A-Za-z ]+$");
    }

    public static boolean isValidPassportNumber(String passportNumber) {
        if (passportNumber == null) {
            return false;
        }

        passportNumber = passportNumber.trim();

        if (passportNumber.isEmpty()) {
            return false;
        }

        // Alphanumeric, 6–9 characters (generic international rule)
        return passportNumber.matches("^[A-Za-z0-9]{6,9}$");
    }

    public static boolean isValidPhoneNumber(String phoneNumber)    {
        if (phoneNumber == null) {
            return false;
        }

        phoneNumber = phoneNumber.trim();

        if (phoneNumber.isEmpty()) {
            return false;
        }

        // Allows optional +, 10–15 digits
        return phoneNumber.matches("^\\+?[0-9]{10,15}$");
    }

    public static boolean isValidRole(String roleStr) {
        if (roleStr == null) {
            return false;
        }

        roleStr = roleStr.trim();

        if (roleStr.isEmpty()) {
            return false;
        }

        try {
            Role.valueOf(roleStr);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }
}
