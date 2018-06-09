package com.lecotec.mixi.model.parameter;

import javax.validation.constraints.Pattern;

public class MerchantUserChangePwdParam extends MerchantUserLoginParam {

    @Pattern(regexp = ".{8,16}", message = "密码是8-16位字母、数字和字符组成")
    private String newPassword;

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}
