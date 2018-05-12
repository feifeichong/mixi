package com.lecotec.mixi.model.parameter;

import java.io.Serializable;
import java.util.List;

public class OrderParam implements Serializable{

	private static final long serialVersionUID = 1L;

	private List<Long> orderIds;
	
	private Long riderId;
	
	private String riderName;
	
	private String orderState;
	
	private String openState;

	public List<Long> getOrderIds() {
		return orderIds;
	}

	public void setOrderIds(List<Long> orderIds) {
		this.orderIds = orderIds;
	}

	public Long getRiderId() {
		return riderId;
	}

	public void setRiderId(Long riderId) {
		this.riderId = riderId;
	}

	public String getRiderName() {
		return riderName;
	}

	public void setRiderName(String riderName) {
		this.riderName = riderName;
	}

	public String getOrderState() {
		return orderState;
	}

	public void setOrderState(String orderState) {
		this.orderState = orderState;
	}

	public String getOpenState() {
		return openState;
	}

	public void setOpenState(String openState) {
		this.openState = openState;
	}

	@Override
	public String toString() {
		return "OrderParam [orderIds=" + orderIds + ", riderId=" + riderId + ", riderName=" + riderName
				+ ", orderState=" + orderState + ", openState=" + openState + "]";
	}
}
