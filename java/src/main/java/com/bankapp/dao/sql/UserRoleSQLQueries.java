package com.bankapp.dao.sql;

public class UserRoleSQLQueries {

    // CREATE
    public static final String CREATE_USER_ROLE =
            "INSERT INTO Roles (user_id, user_role) VALUES (?, ?)";

    // READ
    public static final String SELECT_USER_ROLE_BY_ID =
            "SELECT * FROM Roles WHERE role_id = ?";
    public static final String SELECT_ROLE_BY_USER_ID =
            "SELECT * FROM Roles WHERE user_id = ?";
    public static final String SELECT_ALL_USER_ROLES =
            "SELECT * FROM Roles";

    // UPDATE
    public static final String UPDATE_USER_ROLE =
            "UPDATE Roles SET user_role = ? WHERE role_id = ?";

    // DELETE
    public static final String DELETE_USER_ROLE =
            "DELETE FROM Roles WHERE role_id = ?";

}
