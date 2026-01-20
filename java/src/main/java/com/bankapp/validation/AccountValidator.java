package com.bankapp.validation;

import com.bankapp.model.AccountStatus;
import com.bankapp.model.AccountType;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class AccountValidator {

    private AccountValidator() {  }

    public static boolean isValidAccountId(String accountIdStr) {
        if (accountIdStr == null || accountIdStr.isEmpty()) {
            return false;
        }

        accountIdStr = accountIdStr.trim();

        try {
            long accountId = Long.parseLong(accountIdStr);
            return accountId > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isValidAccountNumber(String accountNumber) {
        if (accountNumber == null) return false;

        String trimmed = accountNumber.trim();
        return trimmed.matches("^[A-Z0-9]{8,20}$");
    }

    public static boolean isValidAccountOwnerId(String accountOwnerIdStr) {
        if (accountOwnerIdStr == null || accountOwnerIdStr.isEmpty()) {
            return false;
        }

        accountOwnerIdStr = accountOwnerIdStr.trim();

        try {
            long accountOwnerId = Long.parseLong(accountOwnerIdStr);
            return accountOwnerId > 0;
        }  catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isValidAccountType(String accountTypeStr) {
        if (accountTypeStr == null) return false;

        accountTypeStr = accountTypeStr.trim();

        try {
            AccountType.valueOf(accountTypeStr.trim().toUpperCase());
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    public static boolean isValidAccountBalance(String accountBalanceStr) {
        if (accountBalanceStr == null) {
            return false;
        }

        accountBalanceStr = accountBalanceStr.trim();

        if (accountBalanceStr.isEmpty()) {
            return false;
        }

        try {
            BigDecimal accountBalance = new BigDecimal(accountBalanceStr);
            return accountBalance.compareTo(BigDecimal.ZERO) >= 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isValidBicSwiftCode(String bicSwiftCode) {
        if (bicSwiftCode == null) return false;

        String trimmed = bicSwiftCode.trim();
        return trimmed.matches("^[A-Z]{4}[A-Z]{2}[A-Z0-9]{2}([A-Z0-9]{3})?$");
    }

    public static boolean isValidOverdraftLimit(String overdraftLimitStr) {
        if (overdraftLimitStr == null) {
            return false;
        }

        overdraftLimitStr = overdraftLimitStr.trim();

        if (overdraftLimitStr.isEmpty()) {
            return false;
        }

        try {
            BigDecimal overdraftLimit = new BigDecimal(overdraftLimitStr);
            return overdraftLimit.compareTo(BigDecimal.ZERO) >= 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isValidOpeningDate(String openingDateStr) {
        if (openingDateStr == null) return false;

        openingDateStr =  openingDateStr.trim();

        if  (openingDateStr.isEmpty()) {
            return false;
        }

        try {
            LocalDate openingDate = LocalDate.parse(openingDateStr);
            return !openingDate.isAfter(LocalDate.now());
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    public static boolean isValidClosingDate(String openingDateStr, String closingDateStr) {
        if (closingDateStr == null) return true;

        try {
            LocalDate openingDate = LocalDate.parse(openingDateStr.trim());
            LocalDate closingDate = LocalDate.parse(closingDateStr.trim());

            return closingDate.isAfter(openingDate);
        } catch (DateTimeParseException | NullPointerException e) {
            return false;
        }
    }

    public static boolean isValidAccountStatus(String accountStatusStr) {
        if (accountStatusStr == null) return false;

        try {
            AccountStatus.valueOf(accountStatusStr.trim().toUpperCase());
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    public static boolean isValidStatusReason(String statusReason) {
        return statusReason == null ||
                statusReason.trim().length() <= 255;
    }
}
