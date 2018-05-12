package com.lecotec.mixi.model.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import io.swagger.annotations.ApiModelProperty;

/**
 * 用户下单
 * @author XINGYI
 *
 */
@Entity
@Table(name = "mx_ordering")
public class Ordering implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "order_id",columnDefinition = "int DEFAULT NULL COMMENT '订单的ID'")
	private long orderId;
	
	@Column(name = "goods_name",columnDefinition = "VARCHAR(255) DEFAULT NULL COMMENT '商品的名称'")
	private String goodsName; 
	
	@Column(name = "goods_id",columnDefinition = "int DEFAULT NULL COMMENT '商品的ID'")
	private long goodsId;
	
	@Column(name = "shop_name",columnDefinition = "VARCHAR(255) DEFAULT NULL COMMENT '商铺的名称'")
	private String shopName; 
	
	@Column(name = "shop_id",columnDefinition = "int DEFAULT NULL COMMENT '商品的ID'")
	private long shopId;

	@ApiModelProperty(hidden = true)
    @Column(name = "creation_time", insertable = false, columnDefinition = "TIMESTAMP DEFAULT NOW()")
    private Date creationTime;
	
	public Date getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}

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

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public long getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(long goodsId) {
		this.goodsId = goodsId;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public long getShopId() {
		return shopId;
	}

	public void setShopId(long shopId) {
		this.shopId = shopId;
	}

	@Override
	public String toString() {
		return "Ordering [id=" + id + ", orderId=" + orderId + ", goodsName=" + goodsName + ", goodsId=" + goodsId
				+ ", shopName=" + shopName + ", shopId=" + shopId + "]";
	} 
}
