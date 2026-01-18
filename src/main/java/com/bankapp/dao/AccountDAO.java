package com.bankapp.dao;

import com.bankapp.model.Account;
import com.bankapp.model.AccountStatus;
import com.bankapp.model.AccountType;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface AccountDAO {

    // CREATE
    Long createAccount(Account account);

    // READ
    List<Account> getAllAccounts();
    Optional<Account> getAccountById(Long accountId);
    Optional<Account> getAccountByAccountNumber(String accountNumber);
    List<Account> getAccountsByUserId(Long userId);
    boolean accountExistsByAccountNumber(String accountNumber);

    // UPDATE
    boolean changeAccountType(Long accountId, AccountType newType, BigDecimal overdraftLimit);
    boolean updateAccountBalance(Long accountId, BigDecimal newBalance);
    boolean updateAccountStatus(Long accountId, AccountStatus newStatus);

    // DELETE
    boolean deleteAccount(Long accountId);
}
