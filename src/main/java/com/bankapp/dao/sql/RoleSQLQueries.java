package com.bankapp.dao.sql;

public class RoleSQLQueries {

    // INSERT SQL
    public static final String INSERT_ROLE = "INSERT INTO Roles(user_id, user_role) " +
            "VALUES (?, ?)";

    // SELECT SQL
    public static final String SELECT_USER_ROLE = "SELECT user_role FROM Roles WHERE user_id = ?";

}
