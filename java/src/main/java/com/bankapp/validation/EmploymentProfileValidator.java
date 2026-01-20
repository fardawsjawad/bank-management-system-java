package com.bankapp.validation;

import com.bankapp.model.AccountPurpose;
import com.bankapp.model.SourceOfFunds;

import java.math.BigDecimal;

public class EmploymentProfileValidator {

    private EmploymentProfileValidator() { }

    // ----------------------------------------------------
    public static boolean isValidEmploymentProfileId(String employmentProfileIdStr) {
        if (employmentProfileIdStr == null) {
            return false;
        }

        employmentProfileIdStr  = employmentProfileIdStr.trim();

        if (employmentProfileIdStr.isEmpty()) {
            return false;
        }

        try {
            long employmentProfileId = Long.parseLong(employmentProfileIdStr);
            return employmentProfileId > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // ----------------------------------------------------
    public static boolean isValidUserId(String userIdStr) {
        if (userIdStr == null) {
            return false;
        }

        userIdStr  = userIdStr.trim();

        if (userIdStr.isEmpty()) {
            return false;
        }

        try {
            long userId = Long.parseLong(userIdStr);
            return userId > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // ----------------------------------------------------
    public static boolean isValidOccupation(String occupation) {
        if (occupation == null) {
            return false;
        }

        occupation = occupation.trim();

        if (occupation.isEmpty()) {
            return false;
        }

        if (occupation.length() < 2 || occupation.length() > 50) {
            return false;
        }

        return occupation.matches("^[a-zA-Z\\s]+$");
    }

    // ----------------------------------------------------
    public static boolean isValidAnnualIncome(String annualIncomeStr) {
        if (annualIncomeStr == null) {
            return false;
        }

        annualIncomeStr = annualIncomeStr.trim();

        if (annualIncomeStr.isEmpty()) {
            return false;
        }

        try {
            BigDecimal annualIncome = new BigDecimal(annualIncomeStr);
            return annualIncome.compareTo(BigDecimal.ZERO) > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // ----------------------------------------------------
    public static boolean isValidSourceOfFunds(String sourceOfFundsStr) {
        if  (sourceOfFundsStr == null) {
            return false;
        }

        sourceOfFundsStr = sourceOfFundsStr.trim();

        if (sourceOfFundsStr.isEmpty()) {
            return false;
        }

        try {
            SourceOfFunds.valueOf(sourceOfFundsStr);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    // ----------------------------------------------------
    public static boolean isValidAccountPurpose(String accountPurposeStr) {
        if (accountPurposeStr == null) {
            return false;
        }

        accountPurposeStr = accountPurposeStr.trim();

        if (accountPurposeStr.isEmpty()) {
            return false;
        }

        try {
            AccountPurpose.valueOf(accountPurposeStr);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

}
