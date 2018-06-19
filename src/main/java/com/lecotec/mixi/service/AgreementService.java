package com.lecotec.mixi.service;

import com.lecotec.mixi.model.entity.Agreement;
import com.lecotec.mixi.model.parameter.AgreementSearchParam;
import com.lecotec.mixi.repository.AgreementRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

@Service
public class AgreementService {
    @Autowired
    private AgreementRepository agreementRepository;

    public Agreement saveOrUpdate(Agreement agreement) {
        return agreementRepository.save(agreement);
    }

    public Page<Agreement> search(AgreementSearchParam advertisementSearchParam) {
        return agreementRepository.findAll((Specification<Agreement>) (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (!StringUtils.isEmpty(advertisementSearchParam.getName())) {
                predicates.add(criteriaBuilder.like(root.get("name"), "%" + advertisementSearchParam.getName() + "%"));
            }
            if (!StringUtils.isEmpty(advertisementSearchParam.getPosition())) {
                predicates.add(criteriaBuilder.equal(root.get("position"), advertisementSearchParam.getPosition()));
            }
            if (!ObjectUtils.isEmpty(advertisementSearchParam.getBeginTime())) {
                predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("creationTime"), advertisementSearchParam.getBeginTime()));
            }
            if (!ObjectUtils.isEmpty(advertisementSearchParam.getEndTime())) {
                predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("creationTime"), advertisementSearchParam.getEndTime()));
            }

            query.where(criteriaBuilder.and(predicates.toArray(new Predicate[0])));
            return query.getRestriction();
        }, PageRequest.of(advertisementSearchParam.getPageNumber(), advertisementSearchParam.getPageSize()));
    }

    public boolean changeActiveStatus(long id, boolean isActive) {
        return agreementRepository.changeActiveStatus(id, isActive) > 0;
    }

    public boolean deleteById(long id) {
        agreementRepository.deleteById(id);
        return true;
    }

    public boolean deleteBatch(long[] ids) {
        agreementRepository.deleteBatch(ids);
        return true;
    }
}
