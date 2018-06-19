package com.lecotec.mixi.service;

import com.lecotec.mixi.model.entity.Customer;
import com.lecotec.mixi.model.parameter.CustomerSearchParam;
import com.lecotec.mixi.repository.CustomerRepository;
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
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public Customer saveOrUpdateCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer findByPhoneNumber(String phoneNumber) {
        return customerRepository.findByPhoneNumber(phoneNumber);
    }

    public boolean updateCustomerPassword(String phoneNumber, String newPassword) {
        return customerRepository.updateCustomerPassword(phoneNumber, newPassword) > 0;
    }

    public Page<Customer> searchCustomerForMixiConsole(CustomerSearchParam customerSearchParam) {
        return customerRepository.findAll((Specification<Customer>) (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (!StringUtils.isEmpty(customerSearchParam.getPhoneNumber())) {
                predicates.add(criteriaBuilder.like(root.get("phoneNumber"), "%" + customerSearchParam.getPhoneNumber() + "%"));
            }
            if (!StringUtils.isEmpty(customerSearchParam.getNickname())) {
                predicates.add(criteriaBuilder.like(root.get("nickname"), "%" + customerSearchParam.getNickname() + "%"));
            }
            if (!ObjectUtils.isEmpty(customerSearchParam.getBeginTime())) {
                predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("creationTime"), customerSearchParam.getBeginTime()));
            }
            if (!ObjectUtils.isEmpty(customerSearchParam.getEndTime())) {
                predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("creationTime"), customerSearchParam.getEndTime()));
            }

            query.where(criteriaBuilder.and(predicates.toArray(new Predicate[0])));
            return query.getRestriction();
        }, PageRequest.of(customerSearchParam.getPageNumber(), customerSearchParam.getPageSize()));
    }

    public boolean changeActiveStatus(long id, boolean isActive) {
        return customerRepository.changeActiveStatus(id, isActive) > 0;
    }
}
