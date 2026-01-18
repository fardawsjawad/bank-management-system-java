package com.bankapp.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

public class Transaction {

    private Long transactionId;
    private Long fromAccountId;
    private Long toAccountId;
    private TransactionType transactionType;
    private BigDecimal amount;
    private BigDecimal availableBalanceAfter;
    private LocalDateTime transactionDate;
    private TransactionStatus transactionStatus;

    public Transaction() {
    }

    public Transaction(Long transactionId, Long fromAccountId, Long toAccountId,
                       TransactionType transactionType, BigDecimal amount,
                       BigDecimal availableBalanceAfter, LocalDateTime transactionDate,
                       TransactionStatus transactionStatus) {

        this.transactionId = transactionId;
        this.fromAccountId = fromAccountId;
        this.toAccountId = toAccountId;
        this.transactionType = transactionType;
        this.amount = amount;
        this.availableBalanceAfter = availableBalanceAfter;
        this.transactionDate = transactionDate;
        this.transactionStatus = transactionStatus;
    }

    public Transaction(Long fromAccountId, Long toAccountId, TransactionType transactionType,
                       BigDecimal amount, BigDecimal availableBalanceAfter,
                       TransactionStatus transactionStatus) {

        this.fromAccountId = fromAccountId;
        this.toAccountId = toAccountId;
        this.transactionType = transactionType;
        this.amount = amount;
        this.availableBalanceAfter = availableBalanceAfter;
        this.transactionDate = transactionDate;
        this.transactionStatus = transactionStatus;
    }

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public Long getFromAccountId() {
        return fromAccountId;
    }

    public void setFromAccountId(Long fromAccountId) {
        this.fromAccountId = fromAccountId;
    }

    public Long getToAccountId() {
        return toAccountId;
    }

    public void setToAccountId(Long toAccountId) {
        this.toAccountId = toAccountId;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getAvailableBalanceAfter() {
        return availableBalanceAfter;
    }

    public void setAvailableBalanceAfter(BigDecimal availableBalanceAfter) {
        this.availableBalanceAfter = availableBalanceAfter;
    }

    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDateTime transactionDate) {
        this.transactionDate = transactionDate;
    }

    public TransactionStatus getTransactionStatus() {
        return transactionStatus;
    }

    public void setTransactionStatus(TransactionStatus transactionStatus) {
        this.transactionStatus = transactionStatus;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionId=" + transactionId +
                ", fromAccountId=" + fromAccountId +
                ", toAccountId=" + toAccountId +
                ", transactionType=" + transactionType +
                ", amount=" + amount +
                ", availableBalanceAfter=" + availableBalanceAfter +
                ", transactionDate=" + transactionDate +
                ", transactionStatus=" + transactionStatus +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return Objects.equals(transactionId, that.transactionId);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(transactionId);
    }
}
