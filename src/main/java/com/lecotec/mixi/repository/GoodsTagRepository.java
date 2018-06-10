package com.lecotec.mixi.repository;

import com.lecotec.mixi.model.entity.GoodsTag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Repository
public interface GoodsTagRepository extends JpaRepository<GoodsTag, Long> {
    @Transactional
    @Modifying
    @Query("update GoodsTag set isActive=:isActive, modifyTime=:modifyTime where id=:id")
    int updateIsActiveById(@Param("isActive") boolean isActive, @Param("modifyTime") Date modifyTime, @Param("id") long id);
}
