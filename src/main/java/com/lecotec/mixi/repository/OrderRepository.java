package com.lecotec.mixi.repository;

import com.lecotec.mixi.model.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>, JpaSpecificationExecutor<Order> {
    @Modifying
    @Query("update Order t set t.rider.id = :riderId, t.dispatchTime = :dispatchTime, t.status = '进行中' where t.id = :orderId")
    void dispatchToRider(@Param("orderId") long orderId, @Param("riderId") long riderId, @Param("dispatchTime") Date dispatchTime);

    List<Order> findByRiderIdAndStatus(long riderId, String status);

    List<Order> findByCustomerId(long customerId);
}
