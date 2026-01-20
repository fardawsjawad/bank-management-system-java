package com.bankapp.dao.sql;

public class AccountSQLQueries {

    // CREATE
    public static final String INSERT_ACCOUNT = "INSERT INTO Accounts " +
            "(account_owner_id, account_type, account_balance, " +
            "bic_swift_code, overdraft_limit, opening_date, status, transaction_pin_hash) " +
            "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

    // READ
    public static final String SELECT_ALL_NON_DELETED_ACCOUNTS = "SELECT * FROM Accounts";
    public static final String SELECT_NON_DELETED_ACCOUNT_BY_ID = "SELECT * FROM Accounts " +
            "WHERE account_id = ? AND status != 'DELETED'";
    public static final String SELECT_NON_DELETED_ACCOUNT_BY_ACCOUNT_NUMBER = "SELECT * FROM Accounts " +
            "WHERE account_number = ? AND status != 'DELETED'";
    public static final String SELECT_NON_DELETED_ACCOUNTS_BY_USER_ID = "SELECT * FROM Accounts " +
            "WHERE account_owner_id = ? AND status != 'DELETED'";
    public static final String SELECT_ACCOUNT_BALANCE = "SELECT account_balance " +
            "FROM Accounts WHERE account_id = ?";
    public static final String SELECT_ACCOUNT_BALANCE_AND_STATUS = "SELECT account_balance, status " +
            "FROM Accounts WHERE account_id = ?";

    // UPDATE
    public static final String UPDATE_ACCOUNT_TYPE = "UPDATE Accounts SET account_type = ?, overdraft_limit = ? " +
            "WHERE account_id = ? AND status != 'DELETED'";
    public static final String UPDATE_ACCOUNT_BALANCE = "UPDATE Accounts SET account_balance = ? " +
            "WHERE account_id = ? AND status != 'DELETED'";
    public static final String UPDATE_ACCOUNT_STATUS = "UPDATE Accounts SET status = ?, closing_date = null " +
            "WHERE account_id = ? AND status != 'DELETED'";
    public static final String UPDATE_ACCOUNT_STATUS_TO_CLOSED = "UPDATE Accounts SET status = ?, closing_date = CURRENT_DATE " +
            "WHERE account_id = ? AND status NOT IN ('DELETED', 'CLOSED') AND account_balance = 0";

    // DELETE
    public static final String DELETE_ACCOUNT = "UPDATE Accounts SET status = 'DELETED', closing_date = CURRENT_DATE " +
            "WHERE account_id = ? AND status NOT IN ('DELETED', 'CLOSED') AND account_balance  = 0";

    // EXISTS CHECKS
    public static final String CHECK_ACCOUNT_NUMBER_EXISTS =
            "SELECT 1 FROM Accounts WHERE account_number = ? LIMIT 1";
}
