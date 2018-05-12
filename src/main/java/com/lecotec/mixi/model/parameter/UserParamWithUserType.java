package com.lecotec.mixi.model.parameter;

import javax.validation.constraints.Pattern;

public class UserParamWithUserType extends UserParamWithShortMsgCode {

    @Pattern(regexp = "(CUSTOMER)|(RIDER)|(MERCHANT)", message = "用户类型数据有误")
    private String userType;

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

}
