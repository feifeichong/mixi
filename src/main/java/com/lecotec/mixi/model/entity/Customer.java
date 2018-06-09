package com.lecotec.mixi.model.entity;

import com.lecotec.mixi.common.RandomUtil;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.util.Date;

@Entity
@Table(name = "mx_customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(hidden = true)
    private long id;

    @Column(unique = true)
    @ApiModelProperty(hidden = true)
    private String account = RandomUtil.getRandomStringByLength(16);

    @Column(unique = true)
    @Pattern(regexp = "1\\d{10}")
    @ApiModelProperty(required = true)
    private String phoneNumber;

    @Column(unique = true)
    private String email;

    @Column(unique = true)
    private String wechat;

    @Column(unique = true)
    private String qq;

    @Column(unique = true)
    private String webo;

    @Pattern(regexp = ".{8,16}", message = "密码是8-16位字母、数字和字符组成")
    @ApiModelProperty(required = true, value = "密码是8-16位字母、数字和字符组成")
    private String password;

    private String headImage;

    private String nickname = RandomUtil.getRandomStringByLength(8);

    private String birthday;

    @Column(columnDefinition = "TEXT NULL COMMENT '收件人地址列表, 格式为：[{name:\"xxx\", phoneNumber:\"xxx\", address:\"xxx\"},...]'")
    @ApiModelProperty("收件人地址列表, 格式为：[{name:\"xxx\", phoneNumber:\"xxx\", address:\"xxx\"},...]")
    private String receiversJson = "[]";

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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getWebo() {
        return webo;
    }

    public void setWebo(String webo) {
        this.webo = webo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHeadImage() {
        return headImage;
    }

    public void setHeadImage(String headImage) {
        this.headImage = headImage;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public String getReceiversJson() {
        return receiversJson;
    }

    public void setReceiversJson(String receiversJson) {
        this.receiversJson = receiversJson;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
}
