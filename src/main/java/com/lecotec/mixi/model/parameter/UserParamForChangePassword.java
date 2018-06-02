package com.lecotec.mixi.model.parameter;

import javax.validation.constraints.Pattern;

public class UserParamForChangePassword extends UserParamWithPassword {
    @Pattern(regexp = "\\w{8,16}", message = "密码是8至16位以上字母、数字组成")
    private String newPassword;

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}
