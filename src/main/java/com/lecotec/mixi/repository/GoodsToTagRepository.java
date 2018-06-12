package com.lecotec.mixi.repository;

import com.lecotec.mixi.model.entity.GoodsToTag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoodsToTagRepository extends JpaRepository<GoodsToTag, Long> {
    List<GoodsToTag> findByGoodsTagId(long tagId);
}
