package com.lecotec.mixi.controller;

import com.lecotec.mixi.model.entity.SendCost;
import com.lecotec.mixi.model.response.ResponseObject;
import com.lecotec.mixi.model.response.SuccessResponse;
import com.lecotec.mixi.service.SendCostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/merchant/sendCost")
public class SendCostController {
    @Autowired
    private SendCostService sendCostService;

    @GetMapping
    public ResponseObject getSendCost() {
        return new SuccessResponse(sendCostService.getSendCost());
    }

    @PostMapping
    public ResponseObject saveOrUpdate(@Valid @RequestBody SendCost sendCost) {
        return new SuccessResponse(sendCostService.saveOrUpdate(sendCost));
    }
}
