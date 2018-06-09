package com.lecotec.mixi.repository;

import com.lecotec.mixi.model.entity.SendCost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SendCostRepository extends JpaRepository<SendCost, Long> {

}
