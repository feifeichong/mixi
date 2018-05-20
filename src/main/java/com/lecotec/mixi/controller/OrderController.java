package com.lecotec.mixi.controller;

import com.lecotec.mixi.model.entity.Order;
import com.lecotec.mixi.model.parameter.OrderParam;
import com.lecotec.mixi.model.parameter.OrderSearchParam;
import com.lecotec.mixi.model.response.BootstrapTableResult;
import com.lecotec.mixi.model.response.ResponseObject;
import com.lecotec.mixi.model.response.SuccessResponse;
import com.lecotec.mixi.service.OrderService;
import io.swagger.annotations.Api;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@Api(tags = "订单数据接口")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/api/customer/order")
    public ResponseObject saveOrUpdateOrder(@Valid @RequestBody OrderParam orderParam) {
        Order order = new Order();
        BeanUtils.copyProperties(orderParam, order);
        return new SuccessResponse(orderService.saveOrUpdateOrder(order));
    }

    @GetMapping("/api/merchant/order/searchByParam")
    public BootstrapTableResult<Order> searchByParam(OrderSearchParam orderSearchParam) {
        Page<Order> orderPage = orderService.searchByParam(orderSearchParam);
        return new BootstrapTableResult<>(orderPage.getTotalElements(), orderPage.getContent());
    }

    @DeleteMapping("/api/merchant/order/{id}")
    public ResponseObject deleteOrder(@PathVariable("id") long id) {
        return new SuccessResponse(orderService.deleteOrder(id));
    }
}
