package com.lecotec.mixi.controller;

import com.lecotec.mixi.model.entity.RiderBankAccount;
import com.lecotec.mixi.model.response.FailResponse;
import com.lecotec.mixi.model.response.ResponseObject;
import com.lecotec.mixi.model.response.SuccessResponse;
import com.lecotec.mixi.service.RiderBankAccountService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/riderBankAccount")
@Api(value = "/api/riderBankAccount", tags = "骑手银行卡绑定、解绑接口")
public class RiderBankAccountController {

    @Autowired
    private RiderBankAccountService riderBankAccountService;

    @PostMapping
    @ApiOperation("骑手绑定银行卡")
    @ApiImplicitParam(name = "riderBankAccount", value = "银行卡信息", required = true, dataType = "RiderBankAccount")
    public ResponseObject saveRiderBankAccount(@Valid @RequestBody RiderBankAccount riderBankAccount) {
        return new SuccessResponse(riderBankAccountService.saveRiderBankAccount(riderBankAccount));
    }

    @DeleteMapping
    @ApiOperation("骑手解除银行卡绑定")
    @ApiImplicitParam(name = "riderBankAccountId", value = "银行卡信息Id", required = true, dataType = "Long")
    public ResponseObject deleteRiderBankAccount(long riderBankAccountId) {
        return riderBankAccountService.deleteRiderBankAccount(riderBankAccountId)
                ? new SuccessResponse() : new FailResponse("银行卡账户信息不存在");
    }
}