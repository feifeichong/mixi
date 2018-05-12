package com.lecotec.mixi.model.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import io.swagger.annotations.ApiModelProperty;

/**
 * 售后退款
 * @author XINGYI
 *
 */
@Entity
@Table(name = "mx_aftersale")
public class AfterSale implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "order_id",columnDefinition = "BIGINT(20) DEFAULT NULL COMMENT '订单的ID'")
	private long orderId;
	
	@Column(columnDefinition = "varchar(255) DEFAULT NULL COMMENT '售后原因'")
	private String reason;
	
	@Column(name = "other_reason",columnDefinition = "LONGTEXT DEFAULT NULL COMMENT '其他原因'")
	private String otherReason;
	
	@Column(columnDefinition = "varchar(255) DEFAULT NULL COMMENT '图片地址'")
	private String image;
	
	@ApiModelProperty(hidden = true)
    @Column(name = "creation_time", insertable = false, columnDefinition = "TIMESTAMP DEFAULT NOW()")
    private Date creationTime;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getOtherReason() {
		return otherReason;
	}

	public void setOtherReason(String otherReason) {
		this.otherReason = otherReason;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Date getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}

	@Override
	public String toString() {
		return "AfterSale [id=" + id + ", orderId=" + orderId + ", reason=" + reason + ", otherReason=" + otherReason
				+ ", image=" + image + ", creationTime=" + creationTime + "]";
	}
}
