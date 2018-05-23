package com.lecotec.mixi.repository;

import com.lecotec.mixi.model.entity.Goods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface GoodsRepository extends JpaRepository<Goods, Long>, JpaSpecificationExecutor<Goods> {
    @Transactional
    @Modifying
    @Query("update Goods t set t.isActive = :isActive where t.id = :id")
    int changeActiveStatus(@Param("id") long id, @Param("isActive") boolean isActive);

    List<Goods> findByIdIn(List<Long> ids);
}
