package com.lecotec.mixi.service;

import com.lecotec.mixi.model.entity.Order;
import com.lecotec.mixi.model.parameter.OrderSearchParam;
import com.lecotec.mixi.model.response.ResponseObject;
import com.lecotec.mixi.model.response.SuccessResponse;
import com.lecotec.mixi.repository.OrderRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import javax.persistence.criteria.Predicate;
import java.util.*;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

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
        return new SuccessResponse();
    }

    public Map<String, Long> getOrderCount() {
        long newCount = orderRepository.count((root, query, criteriaBuilder) -> query.where(criteriaBuilder.equal(root.get("status"), "新订单")).getRestriction());
        long onGoingCount = orderRepository.count((root, query, criteriaBuilder) -> query.where(criteriaBuilder.equal(root.get("status"), "进行中")).getRestriction());
        long completedCount = orderRepository.count((root, query, criteriaBuilder) -> query.where(criteriaBuilder.equal(root.get("status"), "已完成")).getRestriction());
        long exceptionCount = orderRepository.count((root, query, criteriaBuilder) -> query.where(criteriaBuilder.equal(root.get("status"), "配送异常")).getRestriction());
        long pressedCount = orderRepository.count((root, query, criteriaBuilder) -> query.where(criteriaBuilder.equal(root.get("status"), "催单")).getRestriction());
        long cancelCount = orderRepository.count((root, query, criteriaBuilder) -> query.where(criteriaBuilder.equal(root.get("status"), "取消订单")).getRestriction());
        long returnedCount = orderRepository.count((root, query, criteriaBuilder) -> query.where(criteriaBuilder.equal(root.get("status"), "退单")).getRestriction());
        Map<String, Long> result = new HashMap<>();
        result.put("newCount", newCount);
        result.put("onGoingCount", onGoingCount);
        result.put("completedCount", completedCount);
        result.put("exceptionCount", exceptionCount);
        result.put("pressedCount", pressedCount);
        result.put("cancelCount", cancelCount);
        result.put("returnedCount", returnedCount);
        result.put("totalCount", newCount + onGoingCount + completedCount + exceptionCount + pressedCount + cancelCount + returnedCount);

        return result;
    }

    public List<Order> getOrdersByRiderIdAndStatus(long riderId, String status) {
        return orderRepository.findByRiderIdAndStatus(riderId, status);
    }

    public List<Order> getOrdersByCustomerId(long customerId) {
        return orderRepository.findByCustomerId(customerId);
    }

    public Page<Order> searchByCustomerId(long customerId, int pageNumber, int pageSize) {
        return orderRepository.findAll((root, query, criteriaBuilder) -> query.where(criteriaBuilder.equal(root.get("customerId"), customerId)).getRestriction(), PageRequest.of(pageNumber, pageSize));
    }
}
