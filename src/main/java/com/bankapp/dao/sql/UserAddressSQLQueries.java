package com.bankapp.dao.sql;

public class UserAddressSQLQueries {

    // CREATE
    public static final String CREATE_USER_ADDRESS =
    "INSERT INTO UserAddress " +
            "(user_id, address_type, address_line_1, " +
            "address_line_2, locality, city, district, " +
            "state_or_province, postal_code, country) " +
            "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    // RETRIEVE
    public static final String SELECT_ADDRESS_BY_ID =
            "SELECT * FROM UserAddress WHERE address_id = ?";
    public static final String SELECT_ADDRESS_BY_USER_ID =
            "SELECT * FROM UserAddress WHERE user_id = ?";
    public static final String SELECT_ALL_ADDRESSES =
            "SELECT * FROM UserAddress";
    public static final String SELECT_ADDRESS_ID_BY_USER_ID =
            "SELECT address_id FROM UserAddress WHERE user_id = ?";

    // UPDATE
    public static final String UPDATE_USER_ADDRESS =
            "UPDATE UserAddress SET address_type = ?, address_line_1 = ?, " +
                    "address_line_2 = ?, locality = ?, city = ?, district = ?, " +
                    "state_or_province = ?, postal_code = ?, country = ? " +
                    "WHERE address_id = ?";

    // DELETE
    public static final String DELETE_USER_ADDRESS =
            "DELETE FROM UserAddress WHERE address_id = ?";
    public static final String DELETE_ADDRESSES_BY_USER_ID =
            "DELETE FROM UserAddress WHERE user_id = ?";

    // CHECK
    public static final String CHECK_ADDRESS_EXISTS =
            "SELECT 1 FROM UserAddress WHERE address_id = ? LIMIT 1";
}
