package com.lecotec.mixi.service;

import com.lecotec.mixi.model.entity.Goods;
import com.lecotec.mixi.model.parameter.GoodsSearchParam;
import com.lecotec.mixi.repository.GoodsRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;


@Service
public class GoodsService {

    @Autowired
    private GoodsRepository goodsRepository;

    public Goods saveGoods(Goods goods) {
        return goodsRepository.save(goods);
    }

    public Page<Goods> searchByParam(GoodsSearchParam goodsSearchParam) {
        return goodsRepository.findAll((Specification<Goods>) (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (!StringUtils.isEmpty(goodsSearchParam.getName())) {
                predicates.add(criteriaBuilder.like(root.get("name"), "%" + goodsSearchParam.getName() + "%"));
            }
            if (!ObjectUtils.isEmpty(goodsSearchParam.getGoodsTypeId())) {
                predicates.add(criteriaBuilder.equal(root.get("goodsTypeId"), goodsSearchParam.getGoodsTypeId()));
            }
            if (!ObjectUtils.isEmpty(goodsSearchParam.getIsActive())) {
                predicates.add(criteriaBuilder.equal(root.get("isActive"), goodsSearchParam.getIsActive()));
            }

            query.where(criteriaBuilder.and(predicates.toArray(new Predicate[0])));
            return query.getRestriction();
        }, PageRequest.of(goodsSearchParam.getPageNumber(), goodsSearchParam.getPageSize()));
    }

    public boolean changeActiveStatus(long id, boolean isActive) {
        return goodsRepository.changeActiveStatus(id, isActive) > 0;
    }

    public boolean deleteGoods(long id) {
        goodsRepository.deleteById(id);
        return true;
    }
}
