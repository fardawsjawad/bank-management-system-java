package com.bankapp.model;

public class UserRole {

    private Long roleId;
    private Long userId;
    private Role userRole;

    public UserRole(Long roleId, Long userId, Role userRole) {
        this.roleId = roleId;
        this.userId = userId;
        this.userRole = userRole;
    }

    public UserRole(Long userId, Role userRole) {
        this.userId = userId;
        this.userRole = userRole;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Role getUserRole() {
        return userRole;
    }

    public void setUserRole(Role userRole) {
        this.userRole = userRole;
    }

    @Override
    public String toString() {
        return "UserRole{" +
                "roleId=" + roleId +
                ", userId=" + userId +
                ", userRole=" + userRole +
                '}';
    }
}
