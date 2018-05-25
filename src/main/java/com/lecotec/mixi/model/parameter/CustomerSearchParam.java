package com.lecotec.mixi.model.parameter;

import org.apache.commons.lang3.time.DateUtils;

import java.text.ParseException;
import java.util.Date;

public class CustomerSearchParam extends PageParam {
    private String phoneNumber;
    private String nickname;
    private String beginTime;
    private String endTime;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

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
            return DateUtils.addDays(date,1);
        } catch (ParseException e) {
            return null;
        }
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
