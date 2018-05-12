package com.lecotec.mixi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lecotec.mixi.model.entity.*;

@Repository
public interface BwcRuleReponsitory extends JpaRepository<BwcRule, Long>{

	@Modifying
	@Transactional
	@Query("update BwcRule b set b.zmScore = :zmScore,b.rePayDays = :rePayDays where id = :id")
	int updateBwcRule(@Param("id") long id, @Param("zmScore") int zmScore, @Param("rePayDays") int rePayDays);
}
