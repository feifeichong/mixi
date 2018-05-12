package com.lecotec.mixi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lecotec.mixi.model.entity.SendPrice;

@Repository
public interface SendPriceRepository extends JpaRepository<SendPrice, Long> {

	@Modifying
	@Transactional
	@Query("update SendPrice s set s.startingPrices = :startingPrices, s.sendPrices = :sendPrices, s.sendScope = :sendScope where s.id <> ''")
	int updateSendPrice(@Param("startingPrices") double startingPrices, @Param("sendPrices") double sendPrices, 
			@Param("sendScope") String sendScope);
}
