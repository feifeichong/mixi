package com.lecotec.mixi.model.parameter;

import javax.validation.constraints.NotBlank;

public class UserParamWithShortMsgCode extends UserParam {
    @NotBlank
    private String shortMsgCode;

    public String getShortMsgCode() {
        return shortMsgCode;
    }

    public void setShortMsgCode(String shortMsgCode) {
        this.shortMsgCode = shortMsgCode;
    }
}
