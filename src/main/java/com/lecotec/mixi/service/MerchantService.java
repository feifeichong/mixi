package com.lecotec.mixi.service;

import com.lecotec.mixi.model.entity.Merchant;
import com.lecotec.mixi.model.parameter.MerchantSerchParam;
import com.lecotec.mixi.repository.MerchantRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Service
public class MerchantService {
    @Autowired
    private MerchantRepository merchantRepository;

    public Merchant saveOrUpdate(Merchant merchant) {
        return merchantRepository.save(merchant);
    }

    public Page<Merchant> searchForMixiConsole(MerchantSerchParam merchantSerchParam) {
        return merchantRepository.findAll((Specification<Merchant>) (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (!StringUtils.isEmpty(merchantSerchParam.getName())) {
                predicates.add(criteriaBuilder.like(root.get("name"), "%" + merchantSerchParam.getName() + "%"));
            }
            if (!ObjectUtils.isEmpty(merchantSerchParam.getMerchantType())) {
                predicates.add(criteriaBuilder.equal(root.get("merchantType"), merchantSerchParam.getMerchantType()));
            }
            if (!ObjectUtils.isEmpty(merchantSerchParam.getApprovalStatus())) {
                predicates.add(criteriaBuilder.equal(root.get("approvalStatus"), merchantSerchParam.getApprovalStatus()));
            }

            query.where(criteriaBuilder.and(predicates.toArray(new Predicate[0])));
            return query.getRestriction();
        }, PageRequest.of(merchantSerchParam.getPageNumber(), merchantSerchParam.getPageSize()));
    }

    public boolean delete(long id) {
        merchantRepository.deleteById(id);
        return true;
    }

    public boolean changeActiveStatus(long id, boolean isActive) {
        return merchantRepository.changeActiveStatus(id, isActive) > 0;
    }
}
