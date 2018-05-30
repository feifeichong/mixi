package com.lecotec.mixi.repository;

import com.lecotec.mixi.model.entity.TrainningVideo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface TrainningVideoRepository extends JpaRepository<TrainningVideo, Long>, JpaSpecificationExecutor<TrainningVideo> {

    @Modifying
    @Transactional
    @Query("update TrainningVideo t set t.isActive = :isActive where t.id = :id")
    int changeActiveStatus(@Param("id") long id, @Param("isActive") boolean isActive);
}
