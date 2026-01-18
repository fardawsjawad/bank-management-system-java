package com.bankapp.model;

import java.math.BigDecimal;
import java.util.Objects;

public class EmploymentProfile {

    private Long employmentProfileId;
    private Long userId;
    private String occupation;
    private BigDecimal annualIncome;
    private SourceOfFunds sourceOfFunds;
    private AccountPurpose accountPurpose;

    public EmploymentProfile() {
    }

    public EmploymentProfile(Long employmentProfileId, Long userId, String occupation,
                             BigDecimal annualIncome, SourceOfFunds sourceOfFunds,
                             AccountPurpose accountPurpose) {

        this.employmentProfileId = employmentProfileId;
        this.userId = userId;
        this.occupation = occupation;
        this.annualIncome = annualIncome;
        this.sourceOfFunds = sourceOfFunds;
        this.accountPurpose = accountPurpose;
    }

    public EmploymentProfile(Long employmentProfileId, String occupation, BigDecimal annualIncome,
                             SourceOfFunds sourceOfFunds, AccountPurpose accountPurpose) {

        this.employmentProfileId = employmentProfileId;
        this.occupation = occupation;
        this.annualIncome = annualIncome;
        this.sourceOfFunds = sourceOfFunds;
        this.accountPurpose = accountPurpose;
    }

    public EmploymentProfile(String occupation, BigDecimal annualIncome,
                             SourceOfFunds sourceOfFunds, AccountPurpose accountPurpose) {

        this.occupation = occupation;
        this.annualIncome = annualIncome;
        this.sourceOfFunds = sourceOfFunds;
        this.accountPurpose = accountPurpose;
    }

    public Long getEmploymentProfileId() {
        return employmentProfileId;
    }

    public void setEmploymentProfileId(Long employmentProfileId) {
        this.employmentProfileId = employmentProfileId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public BigDecimal getAnnualIncome() {
        return annualIncome;
    }

    public void setAnnualIncome(BigDecimal annualIncome) {
        this.annualIncome = annualIncome;
    }

    public SourceOfFunds getSourceOfFunds() {
        return sourceOfFunds;
    }

    public void setSourceOfFunds(SourceOfFunds sourceOfFunds) {
        this.sourceOfFunds = sourceOfFunds;
    }

    public AccountPurpose getAccountPurpose() {
        return accountPurpose;
    }

    public void setAccountPurpose(AccountPurpose accountPurpose) {
        this.accountPurpose = accountPurpose;
    }

    @Override
    public String toString() {
        return "EmploymentProfile{" +
                "employmentProfileId=" + employmentProfileId +
                ", userId=" + (userId != null ? userId : null) +
                ", occupation='" + occupation + '\'' +
                ", annualIncome=" + annualIncome +
                ", sourceOfFunds=" + sourceOfFunds +
                ", accountPurpose=" + accountPurpose +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        EmploymentProfile that = (EmploymentProfile) o;
        return Objects.equals(employmentProfileId, that.employmentProfileId);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(employmentProfileId);
    }
}
