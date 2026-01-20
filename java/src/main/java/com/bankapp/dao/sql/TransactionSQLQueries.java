package com.bankapp.dao.sql;

public class TransactionSQLQueries {

    // CREATE
    public static final String CREATE_TRANSACTION = "INSERT INTO Transactions " +
            "(from_account_id, to_account_id, transaction_type, amount, available_balance_after, transaction_date, transaction_status) " +
            "VALUES (?, ?, ?, ?, ?, ?, ?)";

    // READ
    public static final String SELECT_TRANSACTION_BY_ID = "SELECT * FROM Transactions WHERE transaction_id = ?";
    public static final String SELECT_TRANSACTION_BY_ACCOUNT_ID = "SELECT * FROM Transactions " +
            "WHERE from_account_id = ? OR to_account_id = ? " +
            "ORDER BY transaction_date DESC";
    public static final String SELECT_TRANSACTIONS_BY_DATE_RANGE = "SELECT * FROM Transactions " +
            "WHERE (from_account_id = ? OR to_account_id = ?) " +
            "AND transaction_date >= ? " +
            "AND  transaction_date < ? " +
            "ORDER BY transaction_date DESC";
    public static final String SELECT_RECENT_TRANSACTIONS =
            "SELECT * FROM Transactions " +
                    "WHERE (from_account_id = ? OR to_account_id = ?) " +
                    "ORDER BY transaction_date DESC " +
                    "LIMIT ?";
    public static final String SELECT_TRANSACTIONS_BY_STATUS = "SELECT * FROM Transactions " +
            "WHERE transaction_status = ?";


    // UPDATE
    public static final String UPDATE_TRANSACTION_STATUS = "UPDATE Transactions " +
            "SET transaction_status = ? " +
            "WHERE transaction_id = ?";


    // DELETE

}
