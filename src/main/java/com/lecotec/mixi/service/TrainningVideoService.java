package com.lecotec.mixi.service;

import com.lecotec.mixi.model.entity.TrainningVideo;
import com.lecotec.mixi.model.parameter.TrainningVideoSearchParam;
import com.lecotec.mixi.repository.TrainningVideoRepository;
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
public class TrainningVideoService {
    @Autowired
    private TrainningVideoRepository trainningVideoRepository;

    public TrainningVideo saveOrUpdate(TrainningVideo trainningVideo) {
        return trainningVideoRepository.save(trainningVideo);
    }

    public Page<TrainningVideo> searchForConsole(TrainningVideoSearchParam trainningVideoSearchParam) {
        return trainningVideoRepository.findAll((Specification<TrainningVideo>) (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (!StringUtils.isEmpty(trainningVideoSearchParam.getName())) {
                predicates.add(criteriaBuilder.like(root.get("name"), "%" + trainningVideoSearchParam.getName() + "%"));
            }
            if (!ObjectUtils.isEmpty(trainningVideoSearchParam.getBeginTime())) {
                predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("creationTime"), trainningVideoSearchParam.getBeginTime()));
            }
            if (!ObjectUtils.isEmpty(trainningVideoSearchParam.getEndTime())) {
                predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("creationTime"), trainningVideoSearchParam.getEndTime()));
            }

            query.where(criteriaBuilder.and(predicates.toArray(new Predicate[0])));
            return query.getRestriction();
        }, PageRequest.of(trainningVideoSearchParam.getPageNumber(), trainningVideoSearchParam.getPageSize()));
    }

    public boolean changeActiveStatus(long id, boolean isActive) {
        return trainningVideoRepository.changeActiveStatus(id, isActive) > 0;
    }
}
