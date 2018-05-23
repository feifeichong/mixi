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

    @ManyToOne()
    @JoinColumn(name = "station_id", referencedColumnName = "id")
    @ApiModelProperty(hidden = true)
    private Station station;

    @ManyToOne()
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    @ApiModelProperty(hidden = true)
    private Customer customer;

    @Column(name = "original_price")
    private double originalPrice;

    @Column(name = "real_price")
    private double realPrice;

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
    private Date completeTime;

    @Column(name="goods_json_list", columnDefinition = "TEXT NULL")
    @ApiModelProperty(hidden = true)
    private String goodsJsonList = "[]";

    @ManyToOne
    @JoinColumn(name = "rider_id", referencedColumnName = "id")
    @ApiModelProperty(hidden = true)
    private Rider rider;

    @Column(name = "receiver_phone_number")
    private String receiverPhoneNumber;

    @Column(name = "receiver_name")
    private String receiverName;

    @Column(name = "receiver_address")
    private String receiverAddress;

    @Column(name = "receiver_remark")
    private String receiverRemark;

    @Column(name = "goods_total_price")
    private double goodsTotalPrice;

    @Column(name = "first_order_reducion")
    private double firstOrderReducion;

    @Column(name = "full_reducion")
    private double fullReducion;

    @Column(name = "online_pay_reducion")
    private double onlinePayReducion;

    @Column(name = "mealbox_price")
    private double mealBoxPrice;

    @Column(name = "send_price")
    private double sendPrice;

    @Column(name = "total_order_price")
    private double totalOrderPrice;

    @Column(name = "real_order_price")
    private double realOrderPrice;

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

    public Station getStation() {
        return station;
    }

    public void setStation(Station station) {
        this.station = station;
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
}
