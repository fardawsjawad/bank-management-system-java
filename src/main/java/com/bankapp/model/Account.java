package com.bankapp.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public class Account {

    private Long accountId;
    private String accountNumber;
    private String transactionPinHash;
    private Long accountOwnerId;
    private AccountType accountType;
    private BigDecimal accountBalance;
    private String bicSwiftCode;
    private BigDecimal overdraftLimit;
    private LocalDate openingDate;
    private LocalDate closingDate;
    private AccountStatus accountStatus;
    private String statusReason;

    public Account() {
    }

    public Account(Long accountId, String accountNumber, String transactionPinHash, Long accountOwnerId, AccountType accountType,
                   BigDecimal accountBalance, String bicSwiftCode, BigDecimal overdraftLimit,
                   LocalDate openingDate, LocalDate closingDate, AccountStatus accountStatus,
                   String statusReason) {

        this.accountId = accountId;
        this.accountNumber = accountNumber;
        this.transactionPinHash = transactionPinHash;
        this.accountOwnerId = accountOwnerId;
        this.accountType = accountType;
        this.accountBalance = accountBalance;
        this.bicSwiftCode = bicSwiftCode;
        this.overdraftLimit = overdraftLimit;
        this.openingDate = openingDate;
        this.closingDate = closingDate;
        this.accountStatus = accountStatus;

        if (statusReason == null) {
            this.statusReason = "None";
        } else {
            this.statusReason = statusReason;
        }
    }

    public Account(Long accountOwnerId, String transactionPinHash, AccountType accountType,
                   String bicSwiftCode) {

        this.accountOwnerId = accountOwnerId;
        this.transactionPinHash = transactionPinHash;
        this.accountType = accountType;
        this.bicSwiftCode = bicSwiftCode;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Long getAccountOwnerId() {
        return accountOwnerId;
    }

    public void setAccountOwnerId(Long accountOwnerId) {
        this.accountOwnerId = accountOwnerId;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public BigDecimal getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(BigDecimal accountBalance) {
        this.accountBalance = accountBalance;
    }

    public String getBicSwiftCode() {
        return bicSwiftCode;
    }

    public void setBicSwiftCode(String bicSwiftCode) {
        this.bicSwiftCode = bicSwiftCode;
    }

    public BigDecimal getOverdraftLimit() {
        return overdraftLimit;
    }

    public void setOverdraftLimit(BigDecimal overdraftLimit) {
        this.overdraftLimit = overdraftLimit;
    }

    public LocalDate getOpeningDate() {
        return openingDate;
    }

    public void setOpeningDate(LocalDate openingDate) {
        this.openingDate = openingDate;
    }

    public LocalDate getClosingDate() {
        return closingDate;
    }

    public void setClosingDate(LocalDate closingDate) {
        this.closingDate = closingDate;
    }

    public AccountStatus getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(AccountStatus accountStatus) {
        this.accountStatus = accountStatus;
    }

    public String getStatusReason() {
        return statusReason;
    }

    public void setStatusReason(String statusReason) {
        this.statusReason = statusReason;
    }

    public String getTransactionPinHash() {
        return transactionPinHash;
    }

    public void setTransactionPinHash(String transactionPinHash) {
        this.transactionPinHash = transactionPinHash;
    }

//    @Override

    @Override
    public String toString() {
        return "Account{" +
                "accountId=" + accountId +
                ", accountNumber='" + accountNumber + '\'' +
                ", transactionPinHash='" + transactionPinHash + '\'' +
                ", accountOwnerId=" + accountOwnerId +
                ", accountType=" + accountType +
                ", accountBalance=" + accountBalance +
                ", bicSwiftCode='" + bicSwiftCode + '\'' +
                ", overdraftLimit=" + overdraftLimit +
                ", openingDate=" + openingDate +
                ", closingDate=" + closingDate +
                ", accountStatus=" + accountStatus +
                ", statusReason='" + statusReason + '\'' +
                '}';
    }

    ////    public String toString() {
    ////        return "Account{" +
    ////                "accountId=" + accountId +
    ////                ", accountNumber='" + accountNumber + '\'' +
    ////                ", accountOwnerId=" + accountOwnerId +
    ////                ", accountType=" + accountType +
    ////                ", accountBalance=" + accountBalance +
    ////                ", bicSwiftCode='" + bicSwiftCode + '\'' +
    ////                ", overdraftLimit=" + overdraftLimit +
    ////                ", openingDate=" + openingDate +
    ////                ", closingDate=" + closingDate +
    ////                ", accountStatus=" + accountStatus +
    ////                ", statusReason='" + statusReason + '\'' +
    ////                '}';
    ////    }



    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(accountId, account.accountId);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(accountId);
    }
}
