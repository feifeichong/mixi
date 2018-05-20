package com.lecotec.mixi.model.parameter;

import javax.validation.constraints.Positive;

public class PageParam {
    @Positive
    private int pageNumber;

    @Positive
    private int pageSize;

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
