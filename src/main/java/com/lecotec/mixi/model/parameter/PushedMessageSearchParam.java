package com.lecotec.mixi.model.parameter;

import org.apache.commons.lang3.time.DateUtils;

import java.text.ParseException;
import java.util.Date;

public class PushedMessageSearchParam extends PageParam {
    private String title;
    private String publishUser;
    private String beginTime;
    private String endTime;

    public Date getBeginTime() {
        try {
            return DateUtils.parseDate(beginTime, "yyyy-MM-dd");
        } catch (ParseException e) {
            return null;
        }
    }

    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        try {
            Date date = DateUtils.parseDate(endTime, "yyyy-MM-dd");
            return DateUtils.addDays(date, 1);
        } catch (ParseException e) {
            return null;
        }
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublishUser() {
        return publishUser;
    }

    public void setPublishUser(String publishUser) {
        this.publishUser = publishUser;
    }
}
