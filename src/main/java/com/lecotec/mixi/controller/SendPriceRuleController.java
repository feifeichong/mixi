package com.lecotec.mixi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.lecotec.mixi.model.entity.SendPriceRule;
import com.lecotec.mixi.model.response.ResponseObject;
import com.lecotec.mixi.model.response.SuccessResponse;
import com.lecotec.mixi.service.SendPriceRuleService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/sendPriceRule")
@Api(value = "/api/sendPriceRule", tags = "配送费规则")
public class SendPriceRuleController {

	@Autowired
	private SendPriceRuleService sendPriceRuleService;
	
	@PostMapping
	@ApiOperation("配送费规则制定(针对骑手)")
    @ApiImplicitParam(name = "sendPriceRule", value = "配送费规则", required = true, dataType = "SendPrice")
	public ResponseObject saveSendPriceRule(@RequestBody SendPriceRule sendPriceRule) {
		return new SuccessResponse(sendPriceRuleService.saveSendPriceRule(sendPriceRule));
	}
	
	@PutMapping("/updateSendPriceRule")
	@ApiOperation("配送费规则更新")
	@ApiImplicitParam(name = "updateSendPriceRule", value = "配送费规则更新", required = true, dataType = "SendPrice")
	public ResponseObject updateSendPriceRule(@RequestBody SendPriceRule sendPriceRule) {
		long id = sendPriceRule.getId();
		double minOrderPrice = sendPriceRule.getMinOrderPrice();
		double maxOrderPrice = sendPriceRule.getMaxOrderPrice();
		double riderIncome = sendPriceRule.getRiderIncome();
		return new SuccessResponse(sendPriceRuleService.updateSendPriceRule(id, minOrderPrice, maxOrderPrice, riderIncome));
	}
}
