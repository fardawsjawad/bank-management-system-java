package com.bankapp.model;

import java.util.Objects;

public class UserAddress {

    private Long addressId;
    private Long userId;
    private AddressType  addressType;
    private String addressLine1;
    private String addressLine2;
    private String locality;
    private String city;
    private String district;
    private String stateOrProvince;
    private String postalCode;
    private String country;

    public UserAddress() {
    }

    public UserAddress(Long addressId, Long userId, AddressType addressType, String addressLine1,
                       String addressLine2, String locality, String city, String district,
                       String stateOrProvince, String postalCode, String country) {

        this.addressId = addressId;
        this.userId = userId;
        this.addressType = addressType;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.locality = locality;
        this.city = city;
        this.district = district;
        this.stateOrProvince = stateOrProvince;
        this.postalCode = postalCode;
        this.country = country;
    }

    public UserAddress(Long addressId, AddressType addressType, String addressLine1, String addressLine2,
                       String locality, String city, String district, String stateOrProvince,
                       String postalCode, String country) {

        this.addressId = addressId;
        this.addressType = addressType;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.locality = locality;
        this.city = city;
        this.district = district;
        this.stateOrProvince = stateOrProvince;
        this.postalCode = postalCode;
        this.country = country;
    }

    public UserAddress(Long userId, AddressType addressType, String addressLine1, String addressLine2,
                       String locality, String city, String stateOrProvince,
                       String postalCode, String country) {

        this.userId = userId;
        this.addressType = addressType;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.locality = locality;
        this.city = city;
        this.district = null;
        this.stateOrProvince = stateOrProvince;
        this.postalCode = postalCode;
        this.country = country;
    }

    public UserAddress(AddressType addressType, String addressLine1, String addressLine2,
                       String locality, String city, String stateOrProvince,
                       String postalCode, String country) {

        this.userId = userId;
        this.addressType = addressType;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.locality = locality;
        this.city = city;
        this.district = null;
        this.stateOrProvince = stateOrProvince;
        this.postalCode = postalCode;
        this.country = country;
    }

    public UserAddress(AddressType addressType, String addressLine1, String addressLine2,
                       String locality, String city, String district, String stateOrProvince,
                       String postalCode, String country) {

        this.userId = userId;
        this.addressType = addressType;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.locality = locality;
        this.city = city;
        this.district = district;
        this.stateOrProvince = stateOrProvince;
        this.postalCode = postalCode;
        this.country = country;
    }

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public AddressType getAddressType() {
        return addressType;
    }

    public void setAddressType(AddressType addressType) {
        this.addressType = addressType;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getStateOrProvince() {
        return stateOrProvince;
    }

    public void setStateOrProvince(String stateOrProvince) {
        this.stateOrProvince = stateOrProvince;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "UserAddress{" +
                "addressId=" + addressId +
                "userId=" + (userId != null ? userId : null) +
                ", addressType=" + addressType +
                ", addressLine1='" + addressLine1 + '\'' +
                ", addressLine2='" + addressLine2 + '\'' +
                ", locality='" + locality + '\'' +
                ", city='" + city + '\'' +
                ", district='" + district + '\'' +
                ", stateOrProvince='" + stateOrProvince + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", country='" + country + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        UserAddress that = (UserAddress) o;
        return Objects.equals(addressId, that.addressId);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(addressId);
    }
}
