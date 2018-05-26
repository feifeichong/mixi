package com.lecotec.mixi.model.entity;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "mx_merchant")
public class Merchant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(hidden = true)
    private long id;

    private String merchantImage;

    private String name;

    private String address;

    @Column(columnDefinition = "VARCHAR(255) NULL COMMENT '类别：中餐、面食等'")
    @ApiModelProperty("类别：中餐、面食等")
    private String merchantType;

    private String businessTime;

    private Date approvalTime;

    @Column(columnDefinition = "VARCHAR(255) NULL COMMENT '商家的审核状态：未审核、审核通过、审核未通过'")
    private String approvalStatus;

    @ApiModelProperty(hidden = true)
    private boolean isActive = true;

    @ApiModelProperty(hidden = true)
    private Date creationTime = new Date();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMerchantImage() {
        return merchantImage;
    }

    public void setMerchantImage(String merchantImage) {
        this.merchantImage = merchantImage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMerchantType() {
        return merchantType;
    }

    public void setMerchantType(String merchantType) {
        this.merchantType = merchantType;
    }

    public Date getApprovalTime() {
        return approvalTime;
    }

    public void setApprovalTime(Date approvalTime) {
        this.approvalTime = approvalTime;
    }

    public String getApprovalStatus() {
        return approvalStatus;
    }

    public void setApprovalStatus(String approvalStatus) {
        this.approvalStatus = approvalStatus;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean active) {
        isActive = active;
    }

    public String getBusinessTime() {
        return businessTime;
    }

    public void setBusinessTime(String businessTime) {
        this.businessTime = businessTime;
    }
}
