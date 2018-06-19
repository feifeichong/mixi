package com.lecotec.mixi.repository;

import com.lecotec.mixi.model.entity.PushedMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface PushedMessageRepository extends JpaRepository<PushedMessage, Long>, JpaSpecificationExecutor<PushedMessage> {
    @Transactional
    @Modifying
    @Query("delete from PushedMessage t where t.id in :ids")
    void deleteBatch(@Param("ids") long[] ids);
}
