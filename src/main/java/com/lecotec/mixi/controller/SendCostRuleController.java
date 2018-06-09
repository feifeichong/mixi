package com.lecotec.mixi.controller;

import com.lecotec.mixi.model.entity.SendCostRule;
import com.lecotec.mixi.model.response.ResponseObject;
import com.lecotec.mixi.model.response.SuccessResponse;
import com.lecotec.mixi.service.SendCostRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/merchant/sendCostRule")
public class SendCostRuleController {

    @Autowired
    private SendCostRuleService sendCostRuleService;

    @GetMapping("list")
    public ResponseObject findAll() {
        return new SuccessResponse(sendCostRuleService.findAll());
    }

    @PostMapping
    public ResponseObject saveOrUpdate(@Valid @RequestBody List<SendCostRule> sendCostRules) {
        sendCostRuleService.saveOrUpdate(sendCostRules);
        return new SuccessResponse();
    }
}
