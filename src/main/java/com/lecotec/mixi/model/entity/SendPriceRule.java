package com.lecotec.mixi.model.entity;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "mx_send_rule")
public class SendPriceRule implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "order_price_min",columnDefinition = "double DEFAULT NULL COMMENT '订单总额下限'")
	private double minOrderPrice;
	
	@Column(name = "order_price_max",columnDefinition = "double DEFAULT NULL COMMENT '订单总额上限'")
	private double maxOrderPrice;
	
	@Column(name = "rider_income",columnDefinition = "double DEFAULT NULL COMMENT '骑手应得费'")
	private double riderIncome;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public double getMinOrderPrice() {
		return minOrderPrice;
	}

	public void setMinOrderPrice(double minOrderPrice) {
		this.minOrderPrice = minOrderPrice;
	}

	public double getMaxOrderPrice() {
		return maxOrderPrice;
	}

	public void setMaxOrderPrice(double maxOrderPrice) {
		this.maxOrderPrice = maxOrderPrice;
	}

	public double getRiderIncome() {
		return riderIncome;
	}

	public void setRiderIncome(double riderIncome) {
		this.riderIncome = riderIncome;
	}

	@Override
	public String toString() {
		return "SendPriceRule [id=" + id + ", minOrderPrice=" + minOrderPrice + ", maxOrderPrice=" + maxOrderPrice
				+ ", riderIncome=" + riderIncome + "]";
	}
}
