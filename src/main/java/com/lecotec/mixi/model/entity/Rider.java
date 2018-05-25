package com.lecotec.mixi.model.entity;

import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.StringUtils;

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

    @Pattern(regexp = "1\\d{10}")
    @Column(name = "phone_number", unique = true)
    private String phoneNumber;

    @NotBlank(message = "密码不能为空")
    private String password;

    private String name;

    private String sex;

    @Pattern(regexp = "^[1-9]\\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1])$")
    private String birthday;

    private String city;

    @Column(name = "identity_card", columnDefinition = "varchar(255) DEFAULT NULL COMMENT '身份证号码'")
    private String identityCard;

    @Column(name = "rider_with_identity_card_photo_path", columnDefinition = "varchar(255) DEFAULT NULL COMMENT '身份证号码'")
    private String riderWithIdentityCardPhotoPath;

    @Column(name = "positive_photo_of_id_card", columnDefinition = "varchar(255) DEFAULT NULL COMMENT '身份证正面照片地址'")
    private String positivePhotoOfIdCard;

    @Column(name = "negative_photo_of_id_card", columnDefinition = "varchar(255) DEFAULT NULL COMMENT '身份证背面照片地址'")
    private String negativePhotoOfIdCard;

    @Column(name = "health_certificate_photo", columnDefinition = "varchar(255) DEFAULT NULL COMMENT '健康证照片地址'")
    private String healthCertificatePhoto;

    @Column(name = "has_paid_deposit", columnDefinition = "bit(1) DEFAULT NULL COMMENT '是否缴纳保证金'")
    private Boolean hasPaidDeposit;

    @Column(name = "deposit_amount", columnDefinition = "double DEFAULT NULL COMMENT '缴纳的保证金金额'")
    private double depositAmount;

    @Column(name = "exam_score")
    private int examScore;

    @Column(name = "approval_status")
    private String approvalStatus;//审核状态：未审核、审核通过、审核未通过

    @Column(name = "is_start_working")
    private boolean isStartWorking;

    @Column(name = "job_title")
    private String jobTitle;//职称：全职、兼职

    @Column(name = "station_id")
    private long stationId;

    @ApiModelProperty(hidden = true)
    @Column(name = "creation_time", insertable = false, columnDefinition = "TIMESTAMP DEFAULT NOW()")
    private Date creationTime;

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

    public int getExamScore() {
        return examScore;
    }

    public void setExamScore(int examScore) {
        this.examScore = examScore;
    }

    public String getIdentityCard() {
        return identityCard;
    }

    public void setIdentityCard(String identityCard) {
        this.identityCard = identityCard;
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

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public boolean isStartWorking() {
        return isStartWorking;
    }

    public void setStartWorking(boolean startWorking) {
        isStartWorking = startWorking;
    }

    public long getStationId() {
        return stationId;
    }

    public void setStationId(long stationId) {
        this.stationId = stationId;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getApprovalStatus() {
        return approvalStatus;
    }

    public void setApprovalStatus(String approvalStatus) {
        this.approvalStatus = approvalStatus;
    }

    public String getRiderWithIdentityCardPhotoPath() {
        return riderWithIdentityCardPhotoPath;
    }

    public void setRiderWithIdentityCardPhotoPath(String riderWithIdentityCardPhotoPath) {
        this.riderWithIdentityCardPhotoPath = riderWithIdentityCardPhotoPath;
    }
}