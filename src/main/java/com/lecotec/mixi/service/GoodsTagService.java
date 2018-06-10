package com.lecotec.mixi.service;

import com.lecotec.mixi.model.entity.GoodsTag;
import com.lecotec.mixi.repository.GoodsTagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class GoodsTagService {

    @Autowired
    private GoodsTagRepository goodsTagRepository;

    public Page<GoodsTag> getAll(int pageNumber, int pageSize) {
        return goodsTagRepository.findAll(PageRequest.of(pageNumber, pageSize));
    }

    public GoodsTag saveOrUpdate(GoodsTag goodsTag) {
        return goodsTagRepository.save(goodsTag);
    }

    public boolean changeActiveStatus(long id, boolean isActive) {
        return goodsTagRepository.updateIsActiveById(isActive, new Date(), id) > 0;
    }

    public boolean delete(long id) {
        goodsTagRepository.deleteById(id);
        return true;
    }
}
