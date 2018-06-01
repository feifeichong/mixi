package com.lecotec.mixi.repository;

import com.lecotec.mixi.model.entity.PushedMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface PushedMessageRepository extends JpaRepository<PushedMessage, Long>, JpaSpecificationExecutor<PushedMessage> {
}
