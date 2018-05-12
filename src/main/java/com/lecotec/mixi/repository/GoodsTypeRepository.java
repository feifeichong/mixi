package com.lecotec.mixi.repository;

import com.lecotec.mixi.model.entity.GoodsType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

public interface GoodsTypeRepository extends JpaRepository<GoodsType, Long> {
    @Transactional
    @Modifying
    @Query("update GoodsType set isActive=:isActive, modifyTime=:modifyTime where id=:id")
    int updateIsActiveById(@Param("isActive") boolean isActive, @Param("modifyTime") Date modifyTime, @Param("id") long id);

    GoodsType getGoodsTypeById(long id);

    @Transactional
    @Modifying
    @Query("update GoodsType set name=:name, imagePath=:imagePath, modifyTime=:modifyTime where id=:id")
    int updateGoodsType(@Param("name") String name, @Param("imagePath") String imagePath, @Param("modifyTime") Date modifyTime, @Param("id") long id);
}
