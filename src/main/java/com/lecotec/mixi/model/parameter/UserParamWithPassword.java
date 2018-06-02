package com.lecotec.mixi.model.parameter;

import javax.validation.constraints.Pattern;

public class UserParamWithPassword extends UserParam {
    @Pattern(regexp = "\\w{8,16}", message = "密码是8至16位以上字母、数字组成")
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
