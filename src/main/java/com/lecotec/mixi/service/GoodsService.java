package com.lecotec.mixi.service;

import com.lecotec.mixi.model.entity.Goods;
import com.lecotec.mixi.repository.GoodsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoodsService {

    @Autowired
    private GoodsRepository goodsRepository;

    public Goods saveGoods(Goods goods) {
        return goodsRepository.save(goods);
    }
}
