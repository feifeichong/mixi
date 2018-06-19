package com.lecotec.mixi.service;

import com.lecotec.mixi.model.entity.Advertisement;
import com.lecotec.mixi.model.parameter.AdvertisementSearchParam;
import com.lecotec.mixi.repository.AdvertisementRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import javax.persistence.criteria.Predicate;
import java.util.HashSet;
import java.util.Set;

@Service
public class AdvertisementService {
    @Autowired
    private AdvertisementRepository advertisementRepository;

    public Advertisement saveOrUpdate(Advertisement advertisement) {
        return advertisementRepository.save(advertisement);
    }

    public Page<Advertisement> searchForConsole(AdvertisementSearchParam advertisementSearchParam) {
        return advertisementRepository.findAll((Specification<Advertisement>) (root, query, criteriaBuilder) -> {
            Set<Predicate> predicates = new HashSet<>();

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

    public boolean deleteById(long id) {
        advertisementRepository.deleteById(id);
        return true;
    }

    public boolean changeActiveStatus(long id, boolean isActive) {
        return advertisementRepository.changeActiveStatus(id, isActive) > 0;
    }

    public boolean deleteBatch(long[] ids) {
        advertisementRepository.deleteBatch(ids);
        return true;
    }
}
