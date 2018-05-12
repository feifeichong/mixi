package com.lecotec.mixi.repository;


import java.util.*;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lecotec.mixi.model.entity.Order;

@Repository
public interface OrderManagementRepository extends JpaRepository<Order, Integer>{

	/**
	 * 所有订单查询
	 * @param tag
	 * @param pageable
	 * @return
	 */
    Page<Order> findByTag(String tag, Pageable pageable);
    
    /**
     * 根据订单状态查询
     * @param orderState
     * @param tag
     * @param pageable
     * @return
     */
    Page<Order> findByOrderStateAndTag(String orderState, String tag, Pageable pageable);
    
    /**
     * 根据还款状态查询(霸王餐使用)
     * @param repayState
     * @param tag
     * @param pageable
     * @return
     */
    Page<Order> findByRepayStateAndTag(String repayState, String tag, Pageable pageable);
    
    /**
     * 统计各个状态的订单数量
     * @return
     */
    @Query("select orderState as state,count(orderState) as num from Order where tag = :tag and id <> '' group by orderState")
    List<Map<String,Integer>> countOrderStateByTag(@Param("tag")String tag);
    
    /**
     * 派单
     * @param riderId
     * @param riderName
     * @param orderIds
     * @return
     */
    @Modifying
    @Transactional
    @Query("update Order o set o.riderId=:riderId,o.riderName=:riderName where o.id in (:orderIds)")
    int dispatchOrder(@Param("riderId")Long riderId,@Param("riderName")String riderName,@Param("orderIds")List<Long> orderIds);
}
