package com.lecotec.mixi.service;

import com.lecotec.mixi.model.entity.Order;
import com.lecotec.mixi.repository.OrderManagementRepository;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

@Service
public class OrderManagementService {

    @Autowired
    private OrderManagementRepository orderManagementRepository;

    /**
     * 所有的订单查询,tag是自营订单，霸王餐订单，商家订单的标识
     *
     * @param tag
     * @param pageNum
     * @param pageSize
     * @return
     */
    public Page<Order> getPageOrdersForAll(String tag, int pageNum, int pageSize) {
        Pageable pageable = PageRequest.of(pageNum, pageSize, new Sort(Direction.ASC, "id"));
        return orderManagementRepository.findByTag(tag, pageable);
    }

    /**
     * 根据订单状态查询
     * @param tag
     * @param orderState
     * @param pageNum
     * @param pageSize
     * @return
     */
    public Page<Order> getOrdersByOrderState(String tag, String orderState,int pageNum, int pageSize){
    	Pageable pageable = PageRequest.of(pageNum, pageSize, new Sort(Direction.ASC, "id"));
        return orderManagementRepository.findByOrderStateAndTag(orderState, tag, pageable);
    }
    
    /**
     * 根据还款状态查询
     * @param tag
     * @param repayState
     * @param pageNum
     * @param pageSize
     * @return
     */
    public Page<Order> getOrdersByRepayState(String tag, String repayState,int pageNum, int pageSize){
    	Pageable pageable = PageRequest.of(pageNum, pageSize, new Sort(Direction.ASC, "id"));
        return orderManagementRepository.findByRepayStateAndTag(repayState, tag, pageable);
    }
    
    public Order saveOrder(Order order) {
    	return orderManagementRepository.save(order);
    }
    
    public boolean deleteOrderById(int id) {
    	try {
    		orderManagementRepository.deleteById(id);
    	}catch(Exception e) {
    		return false;
    	}
    	
    	return true;
    }
    
    public List<Map<String, Integer>> countOrderStateByTag(String tag){
    	return orderManagementRepository.countOrderStateByTag(tag);
    }
    
    public boolean dispatchOrder(Long riderId,String riderName,List<Long> orderIds){
    	return orderManagementRepository.dispatchOrder(riderId, riderName, orderIds) > 0;
    }
}
