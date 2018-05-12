package com.lecotec.mixi.model.entity;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "mx_send_price")
public class SendPrice implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "starting_price",columnDefinition = "double DEFAULT NULL COMMENT '起送价'")
	private double startingPrices;
	
	@Column(name = "send_price",columnDefinition = "double DEFAULT NULL COMMENT '配送费'")
	private double sendPrices;
	
	@Column(name = "send_scope",columnDefinition = "varchar(255) DEFAULT NULL COMMENT '配送半径'")
	private String sendScope;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public double getStartingPrices() {
		return startingPrices;
	}

	public void setStartingPrices(double startingPrices) {
		this.startingPrices = startingPrices;
	}

	public double getSendPrices() {
		return sendPrices;
	}

	public void setSendPrices(double sendPrices) {
		this.sendPrices = sendPrices;
	}

	public String getSendScope() {
		return sendScope;
	}

	public void setSendScope(String sendScope) {
		this.sendScope = sendScope;
	}

	@Override
	public String toString() {
		return "SendPrice [id=" + id + ", startingPrices=" + startingPrices + ", sendPrices=" + sendPrices + ", sendScope="
				+ sendScope + "]";
	}
}
