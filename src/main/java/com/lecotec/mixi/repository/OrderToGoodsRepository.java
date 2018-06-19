package com.lecotec.mixi.repository;

import com.lecotec.mixi.model.entity.OrderToGoods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderToGoodsRepository extends JpaRepository<OrderToGoods, Long> {
    List<OrderToGoods> findByOrderId(long orderId);
}
