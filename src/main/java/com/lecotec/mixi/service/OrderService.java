package com.lecotec.mixi.service;

import com.alibaba.fastjson.JSONArray;
import com.lecotec.mixi.model.entity.Order;
import com.lecotec.mixi.model.entity.Rider;
import com.lecotec.mixi.model.parameter.OrderSearchParam;
import com.lecotec.mixi.model.response.ResponseObject;
import com.lecotec.mixi.model.response.SuccessResponse;
import com.lecotec.mixi.repository.OrderRepository;
import com.lecotec.mixi.repository.RiderRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private RiderRepository riderRepository;

    public Order saveOrUpdateOrder(Order order) {
        return orderRepository.save(order);
    }

    public Page<Order> searchByParam(OrderSearchParam orderSearchParam) {
        return orderRepository.findAll((root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (!StringUtils.isEmpty(orderSearchParam.getSearchKeyword())) {
                predicates.add(criteriaBuilder.like(root.get("serialNumber"), "%" + orderSearchParam.getSearchKeyword() + "%"));
            }
            if (!ObjectUtils.isEmpty(orderSearchParam.getStatus())) {
                predicates.add(criteriaBuilder.equal(root.get("status"), orderSearchParam.getStatus()));
            }
            if (!ObjectUtils.isEmpty(orderSearchParam.getStationId())) {
                predicates.add(criteriaBuilder.equal(root.get("station").get("id"), orderSearchParam.getStationId()));
            }

            query.where(criteriaBuilder.and(predicates.toArray(new Predicate[0])));
            return query.getRestriction();
        }, PageRequest.of(orderSearchParam.getPageNumber(), orderSearchParam.getPageSize()));
    }

    public boolean deleteOrder(long id) {
        orderRepository.deleteById(id);
        return true;
    }

    @Transactional
    public ResponseObject dispatchToRider(long orderId, long riderId) {
        orderRepository.dispatchToRider(orderId, riderId, new Date());
        Rider rider = riderRepository.getOne(riderId);
        JSONArray orderIds = JSONArray.parseArray(rider.getOrderIdsJson());
        if (!orderIds.contains(orderId)){
            orderIds.add(orderId);
            rider.setOrderIdsJson(orderIds.toJSONString());
            riderRepository.save(rider);
        }
        return new SuccessResponse();
    }
}
