package com.lecotec.mixi.model.entity;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import javax.validation.constraints.PositiveOrZero;
import java.util.Date;

@Entity
@Table
public class SendCostRule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(hidden = true)
    private long id;

    @PositiveOrZero
    private double orderPriceBegin;

    @PositiveOrZero
    private double orderPriceEnd;

    @PositiveOrZero
    private double senderIncome;

    @ApiModelProperty(hidden = true)
    private Date creationTime = new Date();

    public double getOrderPriceBegin() {
        return orderPriceBegin;
    }

    public void setOrderPriceBegin(double orderPriceBegin) {
        this.orderPriceBegin = orderPriceBegin;
    }

    public double getOrderPriceEnd() {
        return orderPriceEnd;
    }

    public void setOrderPriceEnd(double orderPriceEnd) {
        this.orderPriceEnd = orderPriceEnd;
    }

    public double getSenderIncome() {
        return senderIncome;
    }

    public void setSenderIncome(double senderIncome) {
        this.senderIncome = senderIncome;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }
}
