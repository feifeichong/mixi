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

    @ApiModelProperty(hidden = true)
    private String serialNumber = UUID.randomUUID().toString();

    private double originalPrice;

    private double realPrice;

    private String status;

    private String paymentType;

    @ApiModelProperty(hidden = true)
    private Date paymentTime;

    @ApiModelProperty(hidden = true)
    private Date dispatchTime;

    @ApiModelProperty(hidden = true)
    private Date completeTime;

    @Column(columnDefinition = "TEXT NULL")
    @ApiModelProperty(hidden = true)
    private String goodsJsonList = "[]";

    @ManyToOne()
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    @ApiModelProperty(hidden = true)
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "rider_id", referencedColumnName = "id")
    @ApiModelProperty(hidden = true)
    private Rider rider;

    @ManyToOne
    @JoinColumn(name = "station_id", referencedColumnName = "id")
    @ApiModelProperty(hidden = true)
    private Station station;

    private String receiverPhoneNumber;

    private String receiverName;

    private String receiverAddress;

    private String receiverRemark;

    private double goodsTotalPrice;

    private double firstOrderReducion;

    private double fullReducion;

    private double onlinePayReducion;

    private double mealBoxPrice;

    private double sendPrice;

    private double totalOrderPrice;

    private double realOrderPrice;

    @ApiModelProperty(hidden = true)
    private Date creationTime = new Date();

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

    public Date getCompleteTime() {
        return completeTime;
    }

    public void setCompleteTime(Date completeTime) {
        this.completeTime = completeTime;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Rider getRider() {
        return rider;
    }

    public void setRider(Rider rider) {
        this.rider = rider;
    }

    public String getReceiverPhoneNumber() {
        return receiverPhoneNumber;
    }

    public void setReceiverPhoneNumber(String receiverPhoneNumber) {
        this.receiverPhoneNumber = receiverPhoneNumber;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getReceiverAddress() {
        return receiverAddress;
    }

    public void setReceiverAddress(String receiverAddress) {
        this.receiverAddress = receiverAddress;
    }

    public double getGoodsTotalPrice() {
        return goodsTotalPrice;
    }

    public void setGoodsTotalPrice(double goodsTotalPrice) {
        this.goodsTotalPrice = goodsTotalPrice;
    }

    public double getFirstOrderReducion() {
        return firstOrderReducion;
    }

    public void setFirstOrderReducion(double firstOrderReducion) {
        this.firstOrderReducion = firstOrderReducion;
    }

    public double getFullReducion() {
        return fullReducion;
    }

    public void setFullReducion(double fullReducion) {
        this.fullReducion = fullReducion;
    }

    public double getOnlinePayReducion() {
        return onlinePayReducion;
    }

    public void setOnlinePayReducion(double onlinePayReducion) {
        this.onlinePayReducion = onlinePayReducion;
    }

    public double getMealBoxPrice() {
        return mealBoxPrice;
    }

    public void setMealBoxPrice(double mealBoxPrice) {
        this.mealBoxPrice = mealBoxPrice;
    }

    public double getSendPrice() {
        return sendPrice;
    }

    public void setSendPrice(double sendPrice) {
        this.sendPrice = sendPrice;
    }

    public double getTotalOrderPrice() {
        return totalOrderPrice;
    }

    public void setTotalOrderPrice(double totalOrderPrice) {
        this.totalOrderPrice = totalOrderPrice;
    }

    public double getRealOrderPrice() {
        return realOrderPrice;
    }

    public void setRealOrderPrice(double realOrderPrice) {
        this.realOrderPrice = realOrderPrice;
    }

    public String getGoodsJsonList() {
        return goodsJsonList;
    }

    public void setGoodsJsonList(String goodsJsonList) {
        this.goodsJsonList = goodsJsonList;
    }

    public String getReceiverRemark() {
        return receiverRemark;
    }

    public void setReceiverRemark(String receiverRemark) {
        this.receiverRemark = receiverRemark;
    }

    public Station getStation() {
        return station;
    }

    public void setStation(Station station) {
        this.station = station;
    }
}
