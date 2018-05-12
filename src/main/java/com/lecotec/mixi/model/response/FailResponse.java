package com.lecotec.mixi.model.response;

import static com.lecotec.mixi.common.ConstString.FAIL;

public class FailResponse extends ResponseObject {
    public FailResponse() {
        super(FAIL, "");
    }

    public FailResponse(Object data) {
        super(FAIL, data);
    }
}
