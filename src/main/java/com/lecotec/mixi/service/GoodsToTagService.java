package com.lecotec.mixi.service;

import com.lecotec.mixi.repository.GoodsToTagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoodsToTagService {
    @Autowired
    private GoodsToTagRepository goodsToTagRepository;

    public boolean isExistGoodsByGoodsTagId(long tagId) {
        return goodsToTagRepository.findByGoodsTagId(tagId).size() > 0;
    }
}
