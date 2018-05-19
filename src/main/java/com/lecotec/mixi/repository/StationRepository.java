package com.lecotec.mixi.repository;

import com.lecotec.mixi.model.entity.Station;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Repository
public interface StationRepository extends JpaRepository<Station, Long> {
    @Transactional
    @Modifying
    @Query("update Station t set t.isActive = :isActive, t.modifyTime = :modifyTime where t.id = :id")
    int changeActiveStatus(@Param("id") long id, @Param("isActive") boolean isActive, @Param("modifyTime") Date modifyTime);
}
