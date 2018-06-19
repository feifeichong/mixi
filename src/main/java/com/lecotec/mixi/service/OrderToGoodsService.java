package com.lecotec.mixi.service;

import com.lecotec.mixi.model.entity.OrderToGoods;
import com.lecotec.mixi.repository.OrderToGoodsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderToGoodsService {
    @Autowired
    private OrderToGoodsRepository orderToGoodsRepository;

    public List<OrderToGoods> getGoodsListByOrderId(long orderId) {
        return orderToGoodsRepository.findByOrderId(orderId);
    }
}
