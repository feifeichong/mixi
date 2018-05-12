package com.lecotec.mixi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lecotec.mixi.model.entity.AfterSale;
import com.lecotec.mixi.model.response.ResponseObject;
import com.lecotec.mixi.model.response.SuccessResponse;
import com.lecotec.mixi.service.AfterSaleService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/afterSale")
@Api(value = "/api/afterSale", tags = "订单售后退款")
public class AfterSaleController {

	@Autowired
	private AfterSaleService afterSaleService;
	
	@PostMapping
	@ApiOperation("订单售后退款接口")
	@ApiImplicitParam(name = "saveAfterSale", value = "订单售后退款", required = true, dataType = "AfterSale")
	public ResponseObject saveAfterSale(@RequestBody AfterSale afterSale) {
		return new SuccessResponse(afterSaleService.saveAfterSale(afterSale));
	}
}
