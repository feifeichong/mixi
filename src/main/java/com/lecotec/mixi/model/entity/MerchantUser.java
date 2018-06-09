package com.lecotec.mixi.model.entity;

import com.lecotec.mixi.common.RandomUtil;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.Date;

@Entity
public class MerchantUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(hidden = true)
    private long id;

    @NotBlank
    @Column(unique = true)
    private String account;

    @Pattern(regexp = ".{8,16}", message = "密码是8-16位字母、数字和字符组成")
    private String password = RandomUtil.getRandomStringByLength(10);

    @NotBlank
    private String phoneNumber;

    @NotBlank
    private String name;

    @NotBlank
    private String sex;

    @ManyToOne
    @JoinColumn(name = "merchant_user_type_id", referencedColumnName = "id")
    @ApiModelProperty(hidden = true)
    private MerchantUserType merchantUserType;

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

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public MerchantUserType getMerchantUserType() {
        return merchantUserType;
    }

    public void setMerchantUserType(MerchantUserType merchantUserType) {
        this.merchantUserType = merchantUserType;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean active) {
        isActive = active;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }
}
