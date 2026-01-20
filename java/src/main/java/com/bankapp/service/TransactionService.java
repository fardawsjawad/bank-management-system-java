package com.bankapp.service;

import com.bankapp.model.Transaction;
import com.bankapp.model.TransactionStatus;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface TransactionService {

    // CREATE
    Long createTransaction(Transaction transaction);

    // RETRIEVE
    Optional<Transaction> getTransactionById(Long id);
    List<Transaction> getTransactionsByAccountId(Long accountId);
    List<Transaction> getTransactionsByDateRange(Long accountId, LocalDate start, LocalDate end);
    List<Transaction> getRecentTransactions(Long accountId, int limit);
    List<Transaction> getTransactionsByStatus(TransactionStatus status);

    // UPDATE
    boolean updateTransactionStatus(Long transactionId, TransactionStatus newStatus);

    // TRANSACTIONS
    boolean deposit(Long accountId, String pinCodeHash, BigDecimal amount);
    boolean withdraw(Long accountId, String pinCodeHash, BigDecimal amount);
    Long transfer(Long fromAccountId, Long toAccountId, String fromAccountPinCodeHash, BigDecimal amount);
}
