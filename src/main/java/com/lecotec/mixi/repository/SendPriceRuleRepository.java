package com.lecotec.mixi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lecotec.mixi.model.entity.*;

@Repository
public interface SendPriceRuleRepository extends JpaRepository<SendPriceRule, Long>{

	@Modifying
	@Transactional
	@Query("update SendPriceRule s set s.minOrderPrice = :minOrderPrice, s.maxOrderPrice = :maxOrderPrice, s.riderIncome = :riderIncome where id = :id")
	int updateSendPriceRule(@Param("id") long id, @Param("minOrderPrice") double minOrderPrice, 
			@Param("maxOrderPrice") double maxOrderPrice, @Param("riderIncome") double riderIncome);
}
