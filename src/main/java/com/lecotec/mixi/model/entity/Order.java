package com.lecotec.mixi.model.entity;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "mx_order")
public class Order implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(hidden = true)
    private long id;

    @Column(name = "serial_number")
    @ApiModelProperty(hidden = true)
    private String serialNumber = UUID.randomUUID().toString();

    @Column(name = "station_info")
    @ApiModelProperty(hidden = true)
    private String stationInfo;

    @Column(name = "customer_info")
    @ApiModelProperty(hidden = true)
    private String customerInfo;

    @Column(name = "original_price")
    private double originalPrice;

    @Column(name = "real_price")
    private double realPrice;

    @Column(name = "cost_detail")
    @ApiModelProperty(hidden = true)
    private String costDetail;

    private String status;

    @Column(name = "payment_type")
    private String paymentType;

    @Column(name = "payment_time")
    @ApiModelProperty(hidden = true)
    private Date paymentTime;

    @Column(name = "dispatch_time")
    @ApiModelProperty(hidden = true)
    private Date dispatchTime;

    @Column(name = "complete_time")
    @ApiModelProperty(hidden = true)
    private Date complete_time;

    @Column(name = "goods_list", columnDefinition = "TEXT NULL")
    @ApiModelProperty(hidden = true)
    private String goodsList;

    @Column(name = "receiver_info")
    @ApiModelProperty(hidden = true)
    private String receiverInfo;

    @Column(name = "rider_info")
    @ApiModelProperty(hidden = true)
    private String riderInfo;

    @ApiModelProperty(hidden = true)
    @Column(name = "creation_time", insertable = false, columnDefinition = "TIMESTAMP DEFAULT NOW()")
    private Date creationTime;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getStationInfo() {
        return stationInfo;
    }

    public void setStationInfo(String stationInfo) {
        this.stationInfo = stationInfo;
    }

    public String getCustomerInfo() {
        return customerInfo;
    }

    public void setCustomerInfo(String customerInfo) {
        this.customerInfo = customerInfo;
    }

    public double getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(double originalPrice) {
        this.originalPrice = originalPrice;
    }

    public double getRealPrice() {
        return realPrice;
    }

    public void setRealPrice(double realPrice) {
        this.realPrice = realPrice;
    }

    public String getCostDetail() {
        return costDetail;
    }

    public void setCostDetail(String costDetail) {
        this.costDetail = costDetail;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public Date getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(Date paymentTime) {
        this.paymentTime = paymentTime;
    }

    public Date getDispatchTime() {
        return dispatchTime;
    }

    public void setDispatchTime(Date dispatchTime) {
        this.dispatchTime = dispatchTime;
    }

    public Date getComplete_time() {
        return complete_time;
    }

    public void setComplete_time(Date complete_time) {
        this.complete_time = complete_time;
    }

    public String getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(String goodsList) {
        this.goodsList = goodsList;
    }

    public String getReceiverInfo() {
        return receiverInfo;
    }

    public void setReceiverInfo(String receiverInfo) {
        this.receiverInfo = receiverInfo;
    }

    public String getRiderInfo() {
        return riderInfo;
    }

    public void setRiderInfo(String riderInfo) {
        this.riderInfo = riderInfo;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }
}
