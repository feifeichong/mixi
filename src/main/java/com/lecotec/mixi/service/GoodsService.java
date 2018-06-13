package com.lecotec.mixi.service;

import com.lecotec.mixi.model.entity.Goods;
import com.lecotec.mixi.model.parameter.GoodsParamForSave;
import com.lecotec.mixi.model.parameter.GoodsSearchParam;
import com.lecotec.mixi.model.parameter.IdsParam;
import com.lecotec.mixi.repository.GoodsRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class GoodsService {

    @Autowired
    private GoodsRepository goodsRepository;

    public Goods saveGoods(GoodsParamForSave goodsParamForSave) {
        Goods goods = new Goods();
        BeanUtils.copyProperties(goodsParamForSave, goods);
        Goods goodsAddedInfo = goodsRepository.save(goods);
        return goodsAddedInfo;
    }

    public Page<Goods> searchByParam(GoodsSearchParam goodsSearchParam) {
        return goodsRepository.findAll((Specification<Goods>) (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (!StringUtils.isEmpty(goodsSearchParam.getName())) {
                predicates.add(criteriaBuilder.like(root.get("name"), "%" + goodsSearchParam.getName() + "%"));
            }
            if (!ObjectUtils.isEmpty(goodsSearchParam.getGoodsTypeId())) {
                predicates.add(criteriaBuilder.equal(root.get("goodsType"), goodsSearchParam.getGoodsTypeId()));
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

    public Page<Goods> getGoodsByIds(IdsParam idsParam) {
        return goodsRepository.findAll((Specification<Goods>) (root, query, criteriaBuilder) -> {
            if (CollectionUtils.isEmpty(idsParam.getIds())) {
                query.where(root.in(-1L));
            } else {
                query.where(root.in(idsParam.getIds()));
            }
            return query.getRestriction();
        }, PageRequest.of(idsParam.getPageNumber(), idsParam.getPageSize()));
    }

    public boolean isExistGoodsByGoodsTypeId(long id) {
        return goodsRepository.findByGoodsTypeId(id).size() > 0;
    }

    public Map<String, Long> getGoodsCount() {
        long activeCount = goodsRepository.count((root, query, criteriaBuilder) -> query.where(criteriaBuilder.equal(root.get("isActive"), true)).getRestriction());
        long inActiveCount = goodsRepository.count((root, query, criteriaBuilder) -> query.where(criteriaBuilder.equal(root.get("isActive"), false)).getRestriction());
        Map<String, Long> result = new HashMap<>();
        result.put("activeCount", activeCount);
        result.put("inActiveCount", inActiveCount);
        result.put("totalCount", activeCount + inActiveCount);
        return result;
    }

    @Transactional
    public boolean deleteBatch(long[] ids) {
        goodsRepository.deleteBatch(ids);
        return true;
    }
}
