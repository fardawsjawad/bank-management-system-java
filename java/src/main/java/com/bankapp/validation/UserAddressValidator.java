package com.bankapp.validation;

import com.bankapp.model.AddressType;

public class UserAddressValidator {

    private UserAddressValidator() {  }

    public static boolean isValidAddressId(String addressIdStr) {
        if (addressIdStr == null || addressIdStr.isEmpty()) {
            return false;
        }

        try {
            long addressId = Long.parseLong(addressIdStr);
            return addressId > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isValidUserId(String userIdStr) {
        if (userIdStr == null || userIdStr.isEmpty()) {
            return false;
        }

        try {
            long userId = Long.parseLong(userIdStr);
            return userId > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isValidAddressType(String addressTypeStr) {
        if (addressTypeStr == null) return false;

        try {
            AddressType.valueOf(addressTypeStr.trim().toUpperCase());
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    public static boolean isValidAddressLine1(String addressLine1) {
        return addressLine1 != null && !addressLine1.trim().isEmpty();
    }

    public static boolean isValidAddressLine2(String addressLine2) {
        return addressLine2 == null || addressLine2.trim().length() <= 100;
    }

    public static boolean isValidLocality(String locality) {
        return locality != null && !locality.trim().isEmpty();
    }

    public static boolean isValidCity(String city) {
        return city != null && !city.trim().isEmpty();
    }

    public static boolean isValidDistrict(String district) {
        return district == null || district.trim().length() <= 100;
    }

    public static boolean isValidStateOrProvince(String stateOrProvince) {
        return stateOrProvince != null && !stateOrProvince.trim().isEmpty();
    }

    public static boolean isValidPostalCode(String postalCode) {
        if (postalCode == null) return false;

        String trimmed = postalCode.trim();
        return trimmed.matches("^[A-Za-z0-9\\-\\s]{3,10}$");
    }

    public static boolean isValidCountry(String country) {
        return country != null && !country.trim().isEmpty();
    }
}
