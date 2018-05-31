package com.lecotec.mixi.model.parameter;

import org.apache.commons.lang3.time.DateUtils;

import java.text.ParseException;
import java.util.Date;

public class AdvertisementSearchParam extends PageParam {
    private String name;
    private String position;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
