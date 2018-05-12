package com.lecotec.mixi.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import com.lecotec.mixi.model.entity.*;
import com.lecotec.mixi.model.response.ResponseObject;
import com.lecotec.mixi.model.response.SuccessResponse;
import com.lecotec.mixi.model.parameter.UserOrderParam;
import com.lecotec.mixi.service.OrderManagementService;
import com.lecotec.mixi.service.OrderingService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/ordering")
@Api(value = "/api/ordering",tags = "用户下单相关接口")
public class OrderingController {

	@Autowired
	private OrderingService orderingService;
	
	@Autowired
	private OrderManagementService orderManagementService;
	
	@PostMapping
	@ApiOperation("用户下单接口")
    @ApiImplicitParam(name = "saveOrdering", value = "用户下单接口", required = true, dataType = "UserOrderParam")
	public ResponseObject saveOrdering(@RequestBody UserOrderParam orderParam) {
		List<Ordering> list = new ArrayList<Ordering>();
		List<Goods> goods = orderParam.getGoods();
		if(!org.springframework.util.CollectionUtils.isEmpty(goods)) {
			double orderPrice = orderParam.getOrderPrice();
			double sendPrice = orderParam.getSendPrice();
			double boxPrice = orderParam.getBoxPrice();
			long shopId = orderParam.getShopId();
			String shopName = orderParam.getShopName();
			long userId = orderParam.getUserId();
			String userName = orderParam.getUserName();
			String orderTag = orderParam.getOrderTag();
			String payWay = orderParam.getOrderPayway();
			String remark = orderParam.getRemark();
			String userAddress = orderParam.getUserAddress();
			String phoneNo = orderParam.getPhoneNo();
//			String repayState = orderParam.getRepayState();
			double orderAllPrice = orderPrice+sendPrice+boxPrice;
			
			Order order = new Order();
			order.setCustomerId(userId);
			order.setCustomerName(userName);
			order.setOrderPrice(orderAllPrice);
			order.setOpenState(true);
			order.setTag(orderTag);
//			order.setStationId(stationId);
//			order.setStationName(stationName);
			order.setPayway(payWay);
			order.setPayTime(new Date());
			order.setRemark(remark);
			order.setUserAddress(userAddress);
			order.setUserPhoneNo(phoneNo);
			
			order = orderManagementService.saveOrder(order);
			
			for (Goods g : goods) {
				Ordering o = new Ordering();
				o.setGoodsId(g.getId());
				o.setOrderId(order.getId());
				o.setGoodsName(g.getGoodsName());
				o.setShopId(shopId);
				o.setShopName(shopName);
				list.add(o);
			}
			list = orderingService.batchSaveOrdering(list);
		}
		return new SuccessResponse(list);
	}
}
