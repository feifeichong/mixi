package com.lecotec.mixi.model.parameter;

import javax.validation.constraints.NotBlank;

public class UserParamWithPassword extends UserParam {
    @NotBlank
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
