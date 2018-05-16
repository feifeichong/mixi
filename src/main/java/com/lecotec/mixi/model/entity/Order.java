package com.lecotec.mixi.model.entity;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 订单管理的实体类
 *
 * @author XINGYI
 */
@Entity
@Table(name = "mx_order")
public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(hidden = true)
    private long id;

    @Column(name = "rider_user_id", columnDefinition = "BIGINT(20) DEFAULT NULL COMMENT '骑手的ID'")
    private long riderId;

    @Column(name = "rider_user_name", columnDefinition = "varchar(255) DEFAULT NULL COMMENT '骑手的名字'")
    private String riderName;

    @Column(name = "customer_id", columnDefinition = "BIGINT(20) DEFAULT NULL COMMENT '用户的ID'")
    private long customerId;

    @Column(name = "customer_name", columnDefinition = "varchar(255) DEFAULT NULL COMMENT '用户的名字'")
    private String customerName;

    @Column(name = "order_price", columnDefinition = "double DEFAULT NULL COMMENT '订单价格'")
    private Double orderPrice;

    @Column(name = "order_state", columnDefinition = "varchar(255) DEFAULT NULL COMMENT '订单状态'")
    private String orderState;

    @Column(name = "repay_state", columnDefinition = "varchar(255) DEFAULT NULL COMMENT '还款状态'")
    private String repayState;

    @Column(name = "open_state", columnDefinition = "bit(1) DEFAULT NULL COMMENT '启用状态'")
    private Boolean openState;

    @Column(name = "station_id", columnDefinition = "BIGINT(20) DEFAULT NULL COMMENT '站点ID'")
    private long stationId;

    @Column(name = "station_name", columnDefinition = "varchar(255) DEFAULT NULL COMMENT '站点名称'")
    private String stationName;

    @Column(name = "order_tag", columnDefinition = "varchar(255) DEFAULT NULL COMMENT '订单分类标识'")
    private String tag;

    @Column(name = "surplus_nopay", columnDefinition = "int DEFAULT NULL COMMENT '霸王餐月剩余次数'")
    private int surplusNopay;

    @Column(columnDefinition = "varchar(255) DEFAULT NULL COMMENT '支付方式'")
    private String payway;

    @Column(name = "repay_time", columnDefinition = "varchar(255) DEFAULT NULL COMMENT '还款时间'")
    private String repayTime;

    private String remark;

    @Column(name = "pay_time", columnDefinition = "DATETIME DEFAULT NULL COMMENT '支付时间'")
    private Date payTime;

    @Column(name = "user_address", columnDefinition = "varchar(2000) DEFAULT NULL COMMENT '用户地址'")
    private String userAddress;

    @Column(name = "user_phoneno", columnDefinition = "varchar(255) DEFAULT NULL COMMENT '用户电话号码'")
    private String userPhoneNo;

    @ApiModelProperty(hidden = true)
    @Column(name = "creation_time", insertable = false, columnDefinition = "TIMESTAMP DEFAULT NOW()")
    private Date creationTime;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getRiderId() {
        return riderId;
    }

    public void setRiderId(long riderId) {
        this.riderId = riderId;
    }

    public String getRiderName() {
        return riderName;
    }

    public void setRiderName(String riderName) {
        this.riderName = riderName;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Double getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(Double orderPrice) {
        this.orderPrice = orderPrice;
    }

    public String getOrderState() {
        return orderState;
    }

    public void setOrderState(String orderState) {
        this.orderState = orderState;
    }

    public String getRepayState() {
        return repayState;
    }

    public void setRepayState(String repayState) {
        this.repayState = repayState;
    }

    public Boolean getOpenState() {
        return openState;
    }

    public void setOpenState(Boolean openState) {
        this.openState = openState;
    }

    public long getStationId() {
        return stationId;
    }

    public void setStationId(long stationId) {
        this.stationId = stationId;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public int getSurplusNopay() {
        return surplusNopay;
    }

    public void setSurplusNopay(int surplusNopay) {
        this.surplusNopay = surplusNopay;
    }

    public String getPayway() {
        return payway;
    }

    public void setPayway(String payway) {
        this.payway = payway;
    }

    public String getRepayTime() {
        return repayTime;
    }

    public void setRepayTime(String repayTime) {
        this.repayTime = repayTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getUserPhoneNo() {
        return userPhoneNo;
    }

    public void setUserPhoneNo(String userPhoneNo) {
        this.userPhoneNo = userPhoneNo;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    @Override
    public String toString() {
        return "Order [id=" + id + ", riderId=" + riderId + ", riderName=" + riderName + ", customerId=" + customerId
                + ", customerName=" + customerName + ", orderPrice=" + orderPrice + ", orderState=" + orderState
                + ", repayState=" + repayState + ", openState=" + openState + ", stationId=" + stationId
                + ", stationName=" + stationName + ", tag=" + tag + ", surplusNopay=" + surplusNopay + ", payway="
                + payway + ", repayTime=" + repayTime + ", remark=" + remark + ", payTime=" + payTime + ", userAddress="
                + userAddress + ", userPhoneNo=" + userPhoneNo + ", creationTime=" + creationTime + "]";
    }
}
