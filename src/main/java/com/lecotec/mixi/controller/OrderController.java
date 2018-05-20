package com.lecotec.mixi.controller;

import com.lecotec.mixi.model.entity.Order;
import com.lecotec.mixi.model.parameter.OrderParam;
import com.lecotec.mixi.model.response.ResponseObject;
import com.lecotec.mixi.model.response.SuccessResponse;
import com.lecotec.mixi.service.OrderService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/api/customer/order")
    public ResponseObject saveOrUpdateOrder(@Valid @RequestBody OrderParam orderParam) {
        Order order = new Order();
        BeanUtils.copyProperties(orderParam, order);
        return new SuccessResponse(orderService.saveOrUpdateOrder(order));
    }
}
