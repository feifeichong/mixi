package com.lecotec.mixi.controller;

import com.lecotec.mixi.model.response.ResponseObject;
import com.lecotec.mixi.model.response.SuccessResponse;
import com.lecotec.mixi.service.OrderToGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/merchant/orderToGoods")
public class OrderToGoodsController {
    @Autowired
    private OrderToGoodsService orderToGoodsService;

    @GetMapping("getGoodsListByOrderId/{orderId}")
    public ResponseObject getGoodsListByOrderId(@PathVariable("orderId") long orderId) {
        return new SuccessResponse(orderToGoodsService.getGoodsListByOrderId(orderId));
    }
}
