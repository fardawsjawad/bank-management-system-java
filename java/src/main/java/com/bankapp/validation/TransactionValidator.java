package com.bankapp.validation;

import com.bankapp.model.TransactionStatus;
import com.bankapp.model.TransactionType;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class TransactionValidator {
    private TransactionValidator() { }

    // ----------------------------------------------------
    public static boolean isValidTransactionId(String transactionIdStr) {
        if (transactionIdStr == null) {
            return false;
        }

        transactionIdStr = transactionIdStr.trim();

        if (transactionIdStr.isEmpty()) {
            return false;
        }

        try {
            long transactionId = Long.parseLong(transactionIdStr);
            return transactionId > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // ----------------------------------------------------
    public static boolean isValidFromAccountId(String fromAccountIdStr) {

        // Allowed for deposit
        if (fromAccountIdStr == null || fromAccountIdStr.trim().isEmpty()) {
            return true;
        }

        try {
            long fromAccountId = Long.parseLong(fromAccountIdStr.trim());
            return fromAccountId > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // ----------------------------------------------------
    public static boolean isValidToAccountId(String toAccountIdStr) {
        // Allowed for deposit
        if (toAccountIdStr == null || toAccountIdStr.trim().isEmpty()) {
            return true;
        }

        try {
            long toAccountId = Long.parseLong(toAccountIdStr.trim());
            return toAccountId > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // ----------------------------------------------------
    public static boolean isValidTransactionType(String transactionTypeStr) {
        if (transactionTypeStr == null) {
            return false;
        }

        transactionTypeStr = transactionTypeStr.trim();

        if (transactionTypeStr.isEmpty()) {
            return false;
        }

        try {
            TransactionType.valueOf(transactionTypeStr.toUpperCase());
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    // ----------------------------------------------------
    public static boolean isValidAmount(String amountStr) {
        if (amountStr == null) {
            return false;
        }

        amountStr = amountStr.trim();

        if  (amountStr.isEmpty()) {
            return false;
        }

        try {
            BigDecimal amount = new BigDecimal(amountStr);
            return  amount.compareTo(BigDecimal.ZERO) > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // ----------------------------------------------------
    public static boolean isValidAvailableBalanceAfter(String balanceStr) {
        if (balanceStr == null) {
            return false;
        }

        balanceStr = balanceStr.trim();

        if (balanceStr.isEmpty()) {
            return false;
        }

        try {
            BigDecimal balance = new BigDecimal(balanceStr);
            return  balance.compareTo(BigDecimal.ZERO) >= 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // ----------------------------------------------------
    public static boolean isValidTransactionDate(String transactionDateStr) {
        if (transactionDateStr == null) {
            return false;
        }

        transactionDateStr = transactionDateStr.trim();

        if (transactionDateStr.isEmpty()) {
            return false;
        }

        try {
            DateTimeFormatter formatter =
                    DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

            LocalDateTime transactionDate =
                    LocalDateTime.parse(transactionDateStr, formatter);

            return !transactionDate.isAfter(LocalDateTime.now());
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    // ----------------------------------------------------
    public static boolean isValidTransactionStatus(String transactionStatusStr) {
        if (transactionStatusStr == null) {
            return false;
        }

        transactionStatusStr = transactionStatusStr.trim();

        if (transactionStatusStr.isEmpty()) {
            return false;
        }

        try {
            TransactionStatus.valueOf(transactionStatusStr.toUpperCase());
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }
}
