package com.lecotec.mixi.model.parameter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class MerchantUserLoginParam {
    @NotBlank(message = "帐户名不能为空")
    private String account;

    @Pattern(regexp = ".{8,16}", message = "密码是8-16位字母、数字和字符组成")
    private String password;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
