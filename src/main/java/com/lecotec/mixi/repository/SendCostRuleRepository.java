package com.lecotec.mixi.repository;

import com.lecotec.mixi.model.entity.SendCostRule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SendCostRuleRepository extends JpaRepository<SendCostRule, Long> {
}
