package com.bankapp.service;

import com.bankapp.model.Account;
import com.bankapp.model.AccountStatus;
import com.bankapp.model.AccountType;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface AccountService {

    // CREATE
    Long createAccount(Account account);

    // RETRIEVE
    List<Account> getAllAccounts();
    Optional<Account> getAccountById(Long accountId);
    Optional<Account> getAccountByAccountNumber(String accountNumber);
    List<Account> getAccountsByUserId(Long userId);

    // UPDATE
    boolean changeAccountType(Long accountId, AccountType newAccountType);
    boolean updateAccountBalance(Long accountId, BigDecimal newBalance);
    boolean updateAccountStatus(Long accountId,  AccountStatus newStatus);

    // DELETE
    boolean deleteAccount(Long accountId);

    // CHECK
    boolean accountExistsByAccountNumber(String accountNumber);

}
