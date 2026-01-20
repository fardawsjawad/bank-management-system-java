package com.bankapp.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class User {

    private Long userId;
    private String username;
    private String passwordHash;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private Gender gender;
    private String email;
    private String nationality;
    private String passportNumber;
    private String phoneNumber;
    private List<UserAddress> userAddresses;
    private Role role;
    private EmploymentProfile employmentProfiles;

    public  User() {
    }

    public User(Long userId, String username, String passwordHash, String firstName, String lastName,
                LocalDate dateOfBirth, Gender gender, String email, String nationality, String passportNumber,
                String phoneNumber, List<UserAddress> userAddresses, Role role, EmploymentProfile employmentProfiles) {

        this.userId = userId;
        this.username = username;
        this.passwordHash = passwordHash;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.email = email;
        this.nationality = nationality;
        this.passportNumber = passportNumber;
        this.phoneNumber = phoneNumber;
        this.userAddresses = userAddresses;
        this.role = role;
        this.employmentProfiles = employmentProfiles;
    }

    public User(Long userId, String username, String firstName, String lastName,
                LocalDate dateOfBirth, Gender gender, String email, String nationality,
                String passportNumber, String phoneNumber) {

        this.userId = userId;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.email = email;
        this.nationality = nationality;
        this.passportNumber = passportNumber;
        this.phoneNumber = phoneNumber;
        this.userAddresses = new ArrayList<>();
        this.role = null;
    }

    public User(Long userId, String firstName, String lastName, LocalDate dateOfBirth,
                Gender gender, String email, String nationality, String passportNumber,
                String phoneNumber) {

        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.email = email;
        this.nationality = nationality;
        this.passportNumber = passportNumber;
        this.phoneNumber = phoneNumber;
    }

    public User (String firstName, String lastName, LocalDate dateOfBirth, Gender gender,
                 String email, String nationality, String passportNumber, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.email = email;
        this.nationality = nationality;
        this.passportNumber = passportNumber;
        this.phoneNumber = phoneNumber;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<UserAddress> getUserAddresses() {
        return userAddresses;
    }

    public void setUserAddresses(List<UserAddress> userAddresses) {
        this.userAddresses = userAddresses;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public EmploymentProfile getEmploymentProfile() {
        return employmentProfiles;
    }

    public void setEmploymentProfile(EmploymentProfile employmentProfiles) {
        this.employmentProfiles = employmentProfiles;
    }

    @Override
    public String toString() {
        return "User {\n" +
                "  userId = " + userId + ",\n" +
                "  username = '" + username + "',\n" +
                "  firstName = '" + firstName + "',\n" +
                "  lastName = '" + lastName + "',\n" +
                "  dateOfBirth = " + dateOfBirth + ",\n" +
                "  gender = " + gender + ",\n" +
                "  email = '" + email + "',\n" +
                "  nationality = '" + nationality + "',\n" +
                "  passportNumber = '" + passportNumber + "',\n" +
                "  phoneNumber = '" + phoneNumber + "',\n" +
                "  userAddresses = '" + userAddresses + "',\n" +
                "  employmentProfiles = '" + employmentProfiles + "',\n" +
                "  role = " + role + "\n" +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return userId == user.userId;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(userId);
    }
}
