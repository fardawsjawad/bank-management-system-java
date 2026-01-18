package com.bankapp.dao.sql;

public class EmploymentProfileSQLQueries {

    // CREATE
    public static final String CREATE_EMPLOYMENT_PROFILE =
            "INSERT INTO EmploymentProfile " +
            "(user_id, occupation, annual_income, source_of_funds, account_purpose) " +
            "VALUES (?, ?, ?, ?, ?)";

    // READ
    public static final String SELECT_EMPLOYMENT_PROFILE_BY_ID =
            "SELECT * FROM EmploymentProfile WHERE employment_profile_id = ?";
    public static final String SELECT_EMPLOYMENT_PROFILE_BY_USER_ID =
            "SELECT * FROM EmploymentProfile WHERE user_id = ?";
    public static final String SELECT_ALL_EMPLOYMENT_PROFILES =
            "SELECT * FROM EmploymentProfile";
    public static final String SELECT_EMPLOYMENT_PROFILE_ID_BY_USER_ID =
            "SELECT employment_profile_id FROM EmploymentProfile WHERE  user_id = ?";

    // UPDATE
    public static final String UPDATE_EMPLOYMENT_PROFILE =
            "UPDATE EmploymentProfile SET " +
                    "occupation = ?, annual_income = ?, source_of_funds = ?, account_purpose = ? " +
                    "WHERE employment_profile_id = ?";

    // DELETE
    public static final String DELETE_EMPLOYMENT_PROFILE =
            "DELETE FROM EmploymentProfile " +
                    "WHERE employment_profile_id = ?";

    // CHECK
    public static final String CHECK_EMPLOYMENT_PROFILE_EXISTS =
            "SELECT 1 FROM EmploymentProfile WHERE employment_profile_id = ?";
}
