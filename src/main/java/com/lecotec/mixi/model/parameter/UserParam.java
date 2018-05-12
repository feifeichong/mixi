package com.lecotec.mixi.model.parameter;

import javax.validation.constraints.Pattern;

public class UserParam {
    @Pattern(regexp = "1\\d{10}", message = "手机号码格式有误")
    private String phoneNumber;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
