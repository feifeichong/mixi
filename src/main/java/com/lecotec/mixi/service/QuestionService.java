package com.lecotec.mixi.service;

import com.lecotec.mixi.model.entity.Question;
import com.lecotec.mixi.model.parameter.QuestionSearchParam;
import com.lecotec.mixi.repository.QuestionRepository;
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
public class QuestionService {
    @Autowired
    private QuestionRepository questionRepository;

    public Question saveOrUpdate(Question question) {
        return questionRepository.save(question);
    }

    public Page<Question> searchForConsole(QuestionSearchParam questionSearchParam) {
        return questionRepository.findAll((Specification<Question>) (root, query, criteriaBuilder) -> {
            Set<Predicate> predicates = new HashSet<>();

            if (!StringUtils.isEmpty(questionSearchParam.getName())) {
                predicates.add(criteriaBuilder.like(root.get("name"), "%" + questionSearchParam.getName() + "%"));
            }
            if (!ObjectUtils.isEmpty(questionSearchParam.getBeginTime())) {
                predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("creationTime"), questionSearchParam.getBeginTime()));
            }
            if (!ObjectUtils.isEmpty(questionSearchParam.getEndTime())) {
                predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("creationTime"), questionSearchParam.getEndTime()));
            }

            query.where(criteriaBuilder.and(predicates.toArray(new Predicate[0])));
            return query.getRestriction();
        }, PageRequest.of(questionSearchParam.getPageNumber(), questionSearchParam.getPageSize()));
    }

    public boolean deleteById(long id) {
        questionRepository.deleteById(id);
        return true;
    }

    public boolean deleteBatch(long[] ids) {
        questionRepository.deleteBatch(ids);
        return true;
    }
}
