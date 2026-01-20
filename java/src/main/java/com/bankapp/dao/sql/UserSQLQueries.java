package com.bankapp.dao.sql;

public class UserSQLQueries {

    // INSERT SQL
    public static final String INSERT_USER = "INSERT INTO Users " +
            "(password, first_name, last_name, date_of_birth, gender, " +
            "email_address, nationality, passport_number, phone_number) " +
            "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

    // SELECT SQL
    public static final String SELECT_USER_BY_ID =
            "SELECT user_id, username, first_name, " +
                    "last_name, date_of_birth, gender, " +
                    "email_address, nationality, " +
                    "passport_number, phone_number " +
                    "FROM Users WHERE user_id = ?";
    public static final String SELECT_USER_BY_USERNAME =
            "SELECT user_id, username, first_name, " +
                    "last_name, date_of_birth, gender, " +
                    "email_address, nationality, " +
                    "passport_number, phone_number " +
                    "FROM Users WHERE username = ?";
    public static final String SELECT_USER_BY_EMAIL =
            "SELECT user_id, username, first_name, " +
                    "last_name, date_of_birth, gender, " +
                    "email_address, nationality, " +
                    "passport_number, phone_number " +
                    "FROM Users WHERE email_address = ?";

    // UPDATE SQL
    public static final String UPDATE_USER = "UPDATE Users SET first_name = ?, last_name = ?, " +
            "date_of_birth = ?, gender = ?, email_address = ?, nationality = ?, passport_number = ?, phone_number = ? " +
            "WHERE user_id = ?";
    public static final String UPDATE_USER_USERNAME = "UPDATE Users SET username = ? WHERE user_id = ?";
    public static final String UPDATE_USER_PASSWORD = "UPDATE Users SET password = ? WHERE user_id = ?";

    // DELETE SQL
    public static final String DELETE_USER = "DELETE FROM Users WHERE user_id = ?";

    // EXISTS CHECKS
    public static final String CHECK_USERNAME_EXISTS = "SELECT 1 FROM Users WHERE username = ? LIMIT 1";
    public static final String CHECK_EMAIL_EXISTS = "SELECT 1 FROM Users WHERE email_address = ? LIMIT 1";
    public static final String CHECK_USER_ID_EXISTS = "SELECT 1 FROM Users WHERE user_id = ? LIMIT 1";

    // GET USER FOR AUTHENTICATION
    public static final String GET_USER_BY_IDENTIFIER =
            "SELECT * FROM Users WHERE username = ? OR email_address = ?";

}
