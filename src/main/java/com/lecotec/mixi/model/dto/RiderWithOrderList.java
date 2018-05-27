package com.lecotec.mixi.model.dto;

import com.lecotec.mixi.model.entity.Order;
import com.lecotec.mixi.model.entity.Rider;

import java.util.List;

public class RiderWithOrderList extends Rider {
    private List<Order> orderList;

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }
}
