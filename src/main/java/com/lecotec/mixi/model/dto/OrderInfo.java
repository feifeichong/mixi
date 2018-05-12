package com.lecotec.mixi.model.dto;

import com.lecotec.mixi.model.entity.Order;
import com.lecotec.mixi.model.entity.Rider;

import java.io.Serializable;
import java.util.List;

public class OrderInfo implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private List<Order> orders; //订单对象集合
	
	private List<Rider> riders;//骑手对象集合
	
}
