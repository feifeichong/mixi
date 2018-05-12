package com.lecotec.mixi.model.response;

import com.lecotec.mixi.common.ConstString;

public class SuccessResponse extends ResponseObject {
    public SuccessResponse() {
        super(ConstString.SUCCESS, "");
    }

    public SuccessResponse(Object data) {
        super(ConstString.SUCCESS, data);
    }
}
