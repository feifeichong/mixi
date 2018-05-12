package com.lecotec.mixi.model.parameter;

import java.io.Serializable;
import java.util.List;

import com.lecotec.mixi.model.entity.*;

public class UserOrderParam implements Serializable{

	private static final long serialVersionUID = 1L;

	private List<Goods> goods;//商品的ID集合
	
	private Long userId;//用户ID
	
	private String userName;//用户昵称
	
	private Long shopId;//商品ID
	
	private String shopName;//商品名称
	
	private Double orderPrice;//订单金额
	
	private Double boxPrice;//餐盒费
	
	private Double sendPrice;//配送费
	
	private String orderTag;//订单类型
	
	private String orderPayway;//支付方式
	
	private String remark;//用户备注
	
	private String repayState;//支付状态
	
	private String userAddress;//用户地址
	
	private String phoneNo;//用户电话
	
	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getRepayState() {
		return repayState;
	}

	public void setRepayState(String repayState) {
		this.repayState = repayState;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getOrderPayway() {
		return orderPayway;
	}

	public void setOrderPayway(String orderPayway) {
		this.orderPayway = orderPayway;
	}

	public String getOrderTag() {
		return orderTag;
	}

	public void setOrderTag(String orderTag) {
		this.orderTag = orderTag;
	}

	public List<Goods> getGoods() {
		return goods;
	}

	public void setGoods(List<Goods> goods) {
		this.goods = goods;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Long getShopId() {
		return shopId;
	}

	public void setShopId(Long shopId) {
		this.shopId = shopId;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public Double getOrderPrice() {
		return orderPrice;
	}

	public void setOrderPrice(Double orderPrice) {
		this.orderPrice = orderPrice;
	}

	public Double getBoxPrice() {
		return boxPrice;
	}

	public void setBoxPrice(Double boxPrice) {
		this.boxPrice = boxPrice;
	}

	public Double getSendPrice() {
		return sendPrice;
	}

	public void setSendPrice(Double sendPrice) {
		this.sendPrice = sendPrice;
	}

	@Override
	public String toString() {
		return "UserOrderParam [goods=" + goods + ", userId=" + userId + ", userName=" + userName + ", shopId=" + shopId
				+ ", shopName=" + shopName + ", orderPrice=" + orderPrice + ", boxPrice=" + boxPrice + ", sendPrice="
				+ sendPrice + ", orderTag=" + orderTag + ", orderPayway=" + orderPayway + ", remark=" + remark
				+ ", repayState=" + repayState + ", userAddress=" + userAddress + ", phoneNo=" + phoneNo + "]";
	}
}
