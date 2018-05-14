package com.lecotec.mixi.service;

import com.lecotec.mixi.model.entity.GoodsType;
import com.lecotec.mixi.repository.GoodsTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class GoodsTypeService {
    @Autowired
    private GoodsTypeRepository goodsTypeRepository;

    public GoodsType saveGoodsType(GoodsType goodsType) {
        return goodsTypeRepository.save(goodsType);
    }

    public Page<GoodsType> getGoodsTypes(int pageNumber, int pageSize) {
        return goodsTypeRepository.findAll(PageRequest.of(pageNumber, pageSize));
    }

    public boolean changeActiveStatus(long id, boolean isActive) {
        return goodsTypeRepository.updateIsActiveById(isActive, new Date(), id) > 0;
    }

    public boolean deleteGoodsType(long id) {
        goodsTypeRepository.deleteById(id);
        return true;
    }

    public GoodsType getGoodsTypeById(long id) {
        return goodsTypeRepository.getGoodsTypeById(id);
    }

    public boolean updateGoodsType(GoodsType goodsType) {
        return goodsTypeRepository.updateGoodsType(goodsType) > 0;
    }
}
