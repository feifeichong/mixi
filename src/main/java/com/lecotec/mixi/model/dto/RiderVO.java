package com.lecotec.mixi.model.dto;

import com.lecotec.mixi.model.entity.Order;
import com.lecotec.mixi.model.entity.Rider;

import java.util.List;

public class RiderVO extends Rider {
    private List<Order> orders;

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
