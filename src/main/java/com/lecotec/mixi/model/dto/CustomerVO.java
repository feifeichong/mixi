package com.lecotec.mixi.model.dto;

import com.lecotec.mixi.model.entity.Customer;
import com.lecotec.mixi.model.entity.Order;

import java.util.List;

public class CustomerVO extends Customer {
    private List<Order> orders;

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
