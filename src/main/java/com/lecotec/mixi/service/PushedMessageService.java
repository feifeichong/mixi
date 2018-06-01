package com.lecotec.mixi.service;

import com.lecotec.mixi.model.entity.PushedMessage;
import com.lecotec.mixi.model.parameter.PushedMessageSearchParam;
import com.lecotec.mixi.repository.PushedMessageRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.persistence.criteria.Predicate;
import java.util.HashSet;
import java.util.Set;

@Service
public class PushedMessageService {
    @Autowired
    private PushedMessageRepository pushedMessageRepository;

    public PushedMessage saveOrUpdate(PushedMessage pushedMessage) {
        return pushedMessageRepository.save(pushedMessage);
    }

    public boolean deleteById(long id) {
        pushedMessageRepository.deleteById(id);
        return true;
    }

    public Page<PushedMessage> searchForConsole(PushedMessageSearchParam pushedMessageSearchParam) {
        return pushedMessageRepository.findAll((Specification<PushedMessage>) (root, query, criteriaBuilder) -> {
            Set<Predicate> predicates = new HashSet<>();

            if (!StringUtils.isEmpty(pushedMessageSearchParam.getTitle())) {
                predicates.add(criteriaBuilder.like(root.get("title"), "%" + pushedMessageSearchParam.getTitle() + "%"));
            }
            if (!StringUtils.isEmpty(pushedMessageSearchParam.getPublishUser())) {
                predicates.add(criteriaBuilder.like(root.get("publishUser"), "%" + pushedMessageSearchParam.getPublishUser() + "%"));
            }
            if (!ObjectUtils.isEmpty(pushedMessageSearchParam.getBeginTime())) {
                predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("creationTime"), pushedMessageSearchParam.getBeginTime()));
            }
            if (!ObjectUtils.isEmpty(pushedMessageSearchParam.getEndTime())) {
                predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("creationTime"), pushedMessageSearchParam.getEndTime()));
            }

            query.where(criteriaBuilder.and(predicates.toArray(new Predicate[0])));
            return query.getRestriction();
        }, PageRequest.of(pushedMessageSearchParam.getPageNumber(), pushedMessageSearchParam.getPageSize()));
    }
}
