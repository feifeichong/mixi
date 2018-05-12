package com.lecotec.mixi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.lecotec.mixi.model.entity.Agreement;
import com.lecotec.mixi.model.response.ResponseObject;
import com.lecotec.mixi.model.response.SuccessResponse;
import com.lecotec.mixi.service.AgreementService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/agreement")
@Api(value = "/api/agreement", tags = "协议管理")
public class AgreementContorller {

	@Autowired
	private AgreementService agreementService;
	
	@PostMapping
	@ApiOperation("协议管理的新增协议")
    @ApiImplicitParam(name = "saveAgreement", value = "新增协议", required = true, dataType = "Agreement")
	public ResponseObject saveAgreement(@RequestBody Agreement agreement) {
		return new SuccessResponse(agreementService.saveAgreement(agreement));
	}
}
