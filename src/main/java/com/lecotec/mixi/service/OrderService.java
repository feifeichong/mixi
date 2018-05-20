package com.lecotec.mixi.service;

import com.lecotec.mixi.model.entity.Order;
import com.lecotec.mixi.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public Order saveOrUpdateOrder(Order order) {
        return orderRepository.save(order);
    }
}
