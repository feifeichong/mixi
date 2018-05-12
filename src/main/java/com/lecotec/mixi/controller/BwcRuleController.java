package com.lecotec.mixi.controller;

import com.lecotec.mixi.model.entity.BwcRule;
import com.lecotec.mixi.model.response.ResponseObject;
import com.lecotec.mixi.model.response.SuccessResponse;
import com.lecotec.mixi.service.BwcRuleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bwcRule")
@Api(value = "/api/bwcRule", tags = "霸王餐规则设置")
public class BwcRuleController {

    @Autowired
    private BwcRuleService bwcRuleService;

    @PostMapping
    @ApiOperation("新增霸王餐规则")
    @ApiImplicitParam(name = "bwcRule", value = "新增霸王餐规则", required = true, dataType = "BwcRule")
    public ResponseObject saveBwcRule(@RequestBody BwcRule bwcRule) {
        return new SuccessResponse(bwcRuleService.saveBwcRule(bwcRule));
    }
    
    @PutMapping("/updateBwcRule")
    @ApiOperation("霸王餐规则更新接口")
    @ApiImplicitParam(name = "updateBwcRule", value = "更新霸王餐规则", required = true, dataType = "BwcRule")
    public ResponseObject updateBwcRule(@RequestBody BwcRule bwcRule) {
    	long id = bwcRule.getId();
		int zmScore = bwcRule.getZmScore();
		int rePayDays = bwcRule.getRePayDays();
		return new SuccessResponse(bwcRuleService.updateBwcRule(id, zmScore, rePayDays));
    }
}
