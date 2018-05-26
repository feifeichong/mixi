package com.lecotec.mixi.model.entity;

import com.lecotec.mixi.common.RandomUtil;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.Date;

@Entity
@Table(name = "mx_rider")
public class Rider {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(hidden = true)
    private long id;

    @Column(unique = true)
    @ApiModelProperty(hidden = true)
    private String account = RandomUtil.getRandomStringByLength(16);

    @Pattern(regexp = "1\\d{10}")
    @Column(unique = true)
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

    @Pattern(regexp = "[a-zA-Z\\d_]{8,}")
    @ApiModelProperty(required = true)
    private String password;

    private String name;

    private String sex;

    private String birthday;

    private String city;

    @Column(columnDefinition = "VARCHAR(255) NULL COMMENT '身份证号码'")
    private String identityCard;

    @Column(columnDefinition = "VARCHAR(255) NULL COMMENT '手持身份证照片地址'")
    private String riderWithIdentityCardPhotoPath;

    @Column(columnDefinition = "VARCHAR(255) NULL COMMENT '身份证正面照片地址'")
    private String positivePhotoOfIdCard;

    @Column(columnDefinition = "VARCHAR(255) NULL COMMENT '身份证背面照片地址'")
    private String negativePhotoOfIdCard;

    @Column(columnDefinition = "VARCHAR(255) NULL COMMENT '健康证照片地址'")
    private String healthCertificatePhoto;

    @Column(columnDefinition = "BIT(1) NULL COMMENT '是否缴纳保证金'")
    private Boolean hasPaidDeposit;

    @Column(columnDefinition = "DOUBLE NULL COMMENT '缴纳的保证金金额'")
    private double depositAmount;

    @Column(columnDefinition = "INT NULL COMMENT '考试成绩'")
    private int examScore;

    @Column(columnDefinition = "VARCHAR(255) NULL COMMENT '骑手的审核状态：未审核、审核通过、审核未通过'")
    private String approvalStatus;

    private boolean isStartWorking;

    @Column(columnDefinition = "VARCHAR(255) NULL COMMENT '骑手工作类型：全职、兼职'")
    private String jobTitle;

    private long stationId;

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

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getIdentityCard() {
        return identityCard;
    }

    public void setIdentityCard(String identityCard) {
        this.identityCard = identityCard;
    }

    public String getRiderWithIdentityCardPhotoPath() {
        return riderWithIdentityCardPhotoPath;
    }

    public void setRiderWithIdentityCardPhotoPath(String riderWithIdentityCardPhotoPath) {
        this.riderWithIdentityCardPhotoPath = riderWithIdentityCardPhotoPath;
    }

    public String getPositivePhotoOfIdCard() {
        return positivePhotoOfIdCard;
    }

    public void setPositivePhotoOfIdCard(String positivePhotoOfIdCard) {
        this.positivePhotoOfIdCard = positivePhotoOfIdCard;
    }

    public String getNegativePhotoOfIdCard() {
        return negativePhotoOfIdCard;
    }

    public void setNegativePhotoOfIdCard(String negativePhotoOfIdCard) {
        this.negativePhotoOfIdCard = negativePhotoOfIdCard;
    }

    public String getHealthCertificatePhoto() {
        return healthCertificatePhoto;
    }

    public void setHealthCertificatePhoto(String healthCertificatePhoto) {
        this.healthCertificatePhoto = healthCertificatePhoto;
    }

    public Boolean getHasPaidDeposit() {
        return hasPaidDeposit;
    }

    public void setHasPaidDeposit(Boolean hasPaidDeposit) {
        this.hasPaidDeposit = hasPaidDeposit;
    }

    public double getDepositAmount() {
        return depositAmount;
    }

    public void setDepositAmount(double depositAmount) {
        this.depositAmount = depositAmount;
    }

    public int getExamScore() {
        return examScore;
    }

    public void setExamScore(int examScore) {
        this.examScore = examScore;
    }

    public String getApprovalStatus() {
        return approvalStatus;
    }

    public void setApprovalStatus(String approvalStatus) {
        this.approvalStatus = approvalStatus;
    }

    public boolean isStartWorking() {
        return isStartWorking;
    }

    public void setStartWorking(boolean startWorking) {
        isStartWorking = startWorking;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public long getStationId() {
        return stationId;
    }

    public void setStationId(long stationId) {
        this.stationId = stationId;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }
}