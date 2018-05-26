package com.lecotec.mixi.controller;

import com.lecotec.mixi.model.entity.Merchant;
import com.lecotec.mixi.model.entity.Rider;
import com.lecotec.mixi.model.parameter.MerchantSerchParam;
import com.lecotec.mixi.model.response.BootstrapTableResult;
import com.lecotec.mixi.model.response.ResponseObject;
import com.lecotec.mixi.model.response.SuccessResponse;
import com.lecotec.mixi.service.MerchantService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@Api(tags = "商家信息接口")
public class MerchantController {

    @Autowired
    private MerchantService merchantService;

    @PostMapping("/api/merchant")
    @ApiOperation("商家注册接口")
    public ResponseObject saveOrUpdate(@Valid @RequestBody Merchant merchant) {
        return new SuccessResponse(merchantService.saveOrUpdate(merchant));
    }

    @GetMapping("/api/merchant/searchForMixiConsole")
    @ApiOperation("系统后台获取商家列表")
    public BootstrapTableResult<Merchant> searchForMixiConsole(MerchantSerchParam merchantSerchParam) {
        Page<Merchant> result = merchantService.searchForMixiConsole(merchantSerchParam);
        return new BootstrapTableResult<>(result.getTotalElements(), result.getContent());
    }

    @DeleteMapping("/api/merchant/{id}")
    @ApiOperation("后台删除商家信息")
    public ResponseObject delete(@PathVariable("id") long id) {
        return new SuccessResponse(merchantService.delete(id));
    }

    @PutMapping("/api/merchant/changeActiveStatus")
    public ResponseObject changeActiveStatus(long id, boolean isActive) {
        return new SuccessResponse(merchantService.changeActiveStatus(id, isActive));
    }
}
