package com.lecotec.mixi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.lecotec.mixi.model.entity.SendPrice;
import com.lecotec.mixi.model.response.ResponseObject;
import com.lecotec.mixi.model.response.SuccessResponse;
import com.lecotec.mixi.service.SendPriceService;

import io.swagger.annotations.*;

@RestController
@RequestMapping("/api/sendPrice")
@Api(value = "/api/sendPrice", tags = "配送费")
public class SendPriceController {

	@Autowired
	private SendPriceService sendPriceService;
	
	@PostMapping
	@ApiOperation("配送费信息制定(针对用户)")
    @ApiImplicitParam(name = "sendPrice", value = "配送费制定", required = true, dataType = "SendPrice")
	public ResponseObject addSendPrice(@RequestBody SendPrice sendPrice ) {
		return new SuccessResponse(sendPriceService.saveSendPrice(sendPrice));
	}
	
	@PutMapping("/updateSendPrice")
    @ApiOperation("配送费更新接口")
    @ApiImplicitParam(name = "updateSendPrice", value = "配送费更新", required = true, dataType = "SendPrice")
	public ResponseObject updateSendPrice(@RequestBody SendPrice sendPrice) {
		
		double startingPrices = sendPrice.getStartingPrices();
		double sendPrices = sendPrice.getSendPrices();
		String sendScope = sendPrice.getSendScope();
		return new SuccessResponse(sendPriceService.updateSendPrice(startingPrices, sendPrices, sendScope));
	}
}
