package com.lecotec.mixi.model.parameter;

public class UserParamForChangePassword extends UserParamWithPassword {
    private String newPassword;

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}
