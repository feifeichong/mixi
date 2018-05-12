package com.lecotec.mixi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lecotec.mixi.model.entity.*;

@Repository
public interface AfterSaleRepository extends JpaRepository<AfterSale, Long>{

}
