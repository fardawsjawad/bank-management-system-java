package com.bankapp.presentation.user_menu.flow;

import com.bankapp.exception.service_exceptions.account_service.AccountNotFoundException;
import com.bankapp.model.Account;
import com.bankapp.model.Transaction;
import com.bankapp.model.TransactionType;
import com.bankapp.presentation.input.ConsoleReader;
import com.bankapp.service.AccountService;
import com.bankapp.service.TransactionService;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class TransactionFlow {

    private final TransactionService transactionService;
    private final AccountService accountService;

    public TransactionFlow(
            TransactionService transactionService,
            AccountService accountService
            ) {
        this.transactionService = transactionService;
        this.accountService = accountService;
    }

    public void deposit() {
        System.out.print("\nEnter account ID: ");
        Long accountId = ConsoleReader.readLong();

        System.out.print("Enter your PIN Code: ");
        String pinCode = ConsoleReader.readString();

        System.out.print("Enter amount to deposit: ");
        BigDecimal amount = ConsoleReader.readBigDecimal();

        try {
            boolean deposited = transactionService.deposit(accountId, pinCode, amount);
            if (deposited) {
                System.out.println("Amount successfully deposited");
            } else {
                System.out.println("Amount failed to deposit");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage() + "\n");
        }
    }

    public void withdraw() {
        System.out.print("\nEnter account ID: ");
        Long accountId = ConsoleReader.readLong();

        System.out.print("Enter your PIN code: ");
        String pinCode = ConsoleReader.readString();

        System.out.print("Enter amount to withdraw: ");
        BigDecimal amount = ConsoleReader.readBigDecimal();

        try {
            boolean withdrawn = transactionService.withdraw(accountId, pinCode, amount);
            if (withdrawn) {
                System.out.println("Amount successfully withdrawn");
            } else  {
                System.out.println("Amount failed to withdraw");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage() + "\n");
        }
    }

    public void transfer() {
        System.out.print("\nEnter your account ID: ");
        Long fromAccountId = ConsoleReader.readLong();

        System.out.print("Enter the beneficiary's account ID: ");
        Long toAccountId = ConsoleReader.readLong();

        System.out.print("Enter your PIN code: ");
        String pinCode = ConsoleReader.readString();

        System.out.print("Enter amount to transfer: ");
        BigDecimal amount = ConsoleReader.readBigDecimal();

        try {
            Long transactionId = transactionService.transfer(fromAccountId, toAccountId, pinCode, amount);
            if (transactionId != null) {
                System.out.println("Amount successfully transferred.");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage() + "\n");
        }
    }

    public void viewTransactions(Long accountOwnerId) {
        System.out.print("\nEnter Account ID: ");
        Long accountId = ConsoleReader.readLong();

        Account account = accountService.getAccountById(accountId)
                .orElseThrow(() ->
                            new AccountNotFoundException("Account not found")
                        );

        if (!account.getAccountOwnerId().equals(accountOwnerId)) {
            System.out.println("Account not found.\n");
            return;
        }

        try {
            List<Transaction> transactions =  transactionService.getTransactionsByAccountId(accountId);
            if (transactions == null || transactions.isEmpty()) {
                System.out.println("No transactions found");
            } else {
                int index = 1;
                for (Transaction transaction : transactions) {
                    System.out.println("\n[Transaction #" + index++ + "]");
                    System.out.println("Transaction ID          : " + transaction.getTransactionId());

                    if (transaction.getTransactionType() == TransactionType.TRANSFER) {
                        System.out.println("Sender's Account ID       : " + transaction.getFromAccountId());
                        System.out.println("Beneficiary's Account ID  : " + transaction.getToAccountId());
                    }

                    System.out.println("Transaction Type        : " +  transaction.getTransactionType());
                    System.out.println("Amount                  : " +  transaction.getAmount());
                    System.out.println("Available Balance After : " + transaction.getAvailableBalanceAfter());
                    System.out.println("Transaction Date        : " + transaction.getTransactionDate());
                    System.out.println("Status                  : " + transaction.getTransactionStatus());
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage() + "\n");
        }
    }

    public void viewRecentTransactions(Long accountOwnerId) {
        System.out.print("\nEnter Account ID: ");
        Long accountId = ConsoleReader.readLong();

        System.out.print("Enter limit to view recent transactions: ");
        int limit = ConsoleReader.readInt();

        Account account = accountService.getAccountById(accountId)
                .orElseThrow(() ->
                        new AccountNotFoundException("Account not found")
                );

        if (!account.getAccountOwnerId().equals(accountOwnerId)) {
            System.out.println("Account not found.\n");
            return;
        }

        try {
            List<Transaction> transactions =  transactionService.getRecentTransactions(accountId, limit);
            if (transactions == null || transactions.isEmpty()) {
                System.out.println("No transactions found");
            } else {
                int index = 1;
                for (Transaction transaction : transactions) {
                    System.out.println("\n[Transaction #" + index++ + "]");
                    System.out.println("Transaction ID          : " + transaction.getTransactionId());

                    if (transaction.getTransactionType() == TransactionType.TRANSFER) {
                        System.out.println("Sender's Account ID       : " + transaction.getFromAccountId());
                        System.out.println("Beneficiary's Account ID  : " + transaction.getToAccountId());
                    }

                    System.out.println("Transaction Type        : " +  transaction.getTransactionType());
                    System.out.println("Amount                  : " +  transaction.getAmount());
                    System.out.println("Available Balance After : " + transaction.getAvailableBalanceAfter());
                    System.out.println("Transaction Date        : " + transaction.getTransactionDate());
                    System.out.println("Status                  : " + transaction.getTransactionStatus());
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage() + "\n");
        }
    }

    public void viewTransactionsByDate(Long accountOwnerId) {
        System.out.print("\nEnter Account ID: ");
        Long accountId = ConsoleReader.readLong();

        System.out.print("Enter start date (yyyy-MM-dd): ");
        LocalDate startDate = ConsoleReader.readLocalDate();

        System.out.print("Enter end date (yyyy-MM-dd): ");
        LocalDate endDate = ConsoleReader.readLocalDate();

        Account account = accountService.getAccountById(accountId)
                .orElseThrow(() ->
                        new AccountNotFoundException("Account not found")
                );

        if (!account.getAccountOwnerId().equals(accountOwnerId)) {
            System.out.println("Account not found.\n");
            return;
        }

        try {
            List<Transaction> transactions =  transactionService.getTransactionsByDateRange(accountId, startDate, endDate);
            if (transactions == null || transactions.isEmpty()) {
                System.out.println("No transactions found");
            } else {
                int index = 1;
                for (Transaction transaction : transactions) {
                    System.out.println("\n[Transaction #" + index++ + "]");
                    System.out.println("Transaction ID          : " + transaction.getTransactionId());

                    if (transaction.getTransactionType() == TransactionType.TRANSFER) {
                        System.out.println("Sender's Account ID       : " + transaction.getFromAccountId());
                        System.out.println("Beneficiary's Account ID  : " + transaction.getToAccountId());
                    }

                    System.out.println("Transaction Type        : " +  transaction.getTransactionType());
                    System.out.println("Amount                  : " +  transaction.getAmount());
                    System.out.println("Available Balance After : " + transaction.getAvailableBalanceAfter());
                    System.out.println("Transaction Date        : " + transaction.getTransactionDate());
                    System.out.println("Status                  : " + transaction.getTransactionStatus());
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage() + "\n");
        }

    }
}
