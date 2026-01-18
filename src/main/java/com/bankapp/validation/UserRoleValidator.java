package com.bankapp.validation;

import com.bankapp.model.AddressType;
import com.bankapp.model.Role;

public class UserRoleValidator {

    private UserRoleValidator() {  }

    public static boolean isValidRoleId(String roleIdStr) {
        if (roleIdStr == null || roleIdStr.trim().isEmpty()) {
            return false;
        }

        try {
            long roleId = Long.parseLong(roleIdStr);
            return roleId > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isValidUserId(String userIdStr) {
        if (userIdStr == null || userIdStr.trim().isEmpty()) {
            return false;
        }

        try {
            long userId = Long.parseLong(userIdStr);
            return userId > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isValidUserRole(String roleStr) {
        if (roleStr == null) return false;

        try {
            Role.valueOf(roleStr.trim().toUpperCase());
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

}
