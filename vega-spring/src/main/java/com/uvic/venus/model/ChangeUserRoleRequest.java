package com.uvic.venus.model;

public class ChangeUserRoleRequest {

    private String username;
    private String role;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public ChangeUserRoleRequest(String username, String role) {
        this.username = username;
        this.role = role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
