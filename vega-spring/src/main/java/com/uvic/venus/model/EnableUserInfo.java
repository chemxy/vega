package com.uvic.venus.model;

public class EnableUserInfo {

    private String username;

    public String getUsername() {
        return username;
    }

    public boolean isEnable() {
        return enable;
    }

    private boolean enable;

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public EnableUserInfo(String username, boolean enable) {
        this.username = username;
        this.enable = enable;
    }
}
