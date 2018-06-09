package com.lecotec.mixi.model.entity;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import javax.validation.constraints.PositiveOrZero;
import java.util.Date;

@Entity
@Table(name = "mx_send_cost")
public class SendCost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(hidden = true)
    private long id;

    @PositiveOrZero
    private double minOrderPriceCanSend;

    @PositiveOrZero
    private double minSendCost;

    @PositiveOrZero
    private double minSendRadius;

    @ApiModelProperty(hidden = true)
    private Date creationTime = new Date();

    public double getMinOrderPriceCanSend() {
        return minOrderPriceCanSend;
    }

    public void setMinOrderPriceCanSend(double minOrderPriceCanSend) {
        this.minOrderPriceCanSend = minOrderPriceCanSend;
    }

    public double getMinSendCost() {
        return minSendCost;
    }

    public void setMinSendCost(double minSendCost) {
        this.minSendCost = minSendCost;
    }

    public double getMinSendRadius() {
        return minSendRadius;
    }

    public void setMinSendRadius(double minSendRadius) {
        this.minSendRadius = minSendRadius;
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
