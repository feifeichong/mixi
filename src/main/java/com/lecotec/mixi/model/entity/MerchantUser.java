package com.lecotec.mixi.model.entity;

import com.lecotec.mixi.common.RandomUtil;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.util.Date;

@Entity
@Table(name = "mx_merchant_user")
public class MerchantUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(hidden = true)
    private long id;

    @Column(unique = true)
    private String account = RandomUtil.getRandomStringByLength(8);

    @Pattern(regexp = "1\\d{10}")
    private String phoneNumber;

    private String name;

    @Pattern(regexp = "[a-zA-Z\\d_]{8,}")
    @ApiModelProperty(required = true)
    private String password;

    private String sex;

    @Column(columnDefinition = "VARCHAR(255) NULL COMMENT '用户类型：系统管理员、员工'")
    private String merchantUserType;

    @ApiModelProperty(hidden = true)
    private Date creationTime = new Date();

    @ManyToOne
    @JoinColumn(name = "merchant_id", referencedColumnName = "id")
    private Merchant merchant;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getMerchantUserType() {
        return merchantUserType;
    }

    public void setMerchantUserType(String merchantUserType) {
        this.merchantUserType = merchantUserType;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Merchant getMerchant() {
        return merchant;
    }

    public void setMerchant(Merchant merchant) {
        this.merchant = merchant;
    }
}
