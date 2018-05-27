package com.lecotec.mixi.service;

import com.lecotec.mixi.model.entity.Rider;
import com.lecotec.mixi.model.parameter.RiderSerchParam;
import com.lecotec.mixi.repository.RiderRepository;
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
public class RiderService {
    @Autowired
    private RiderRepository riderRepository;

    public Rider findByPhoneNumber(String phoneNumber) {
        return riderRepository.findByPhoneNumber(phoneNumber);
    }

    public Rider saveRider(Rider rider) {
        return riderRepository.save(rider);
    }

    public boolean updateRiderPassword(String phoneNumber, String newPassword) {
        return riderRepository.updateRiderPassword(phoneNumber, newPassword) > 0;
    }

    public boolean payedDeposit(String phoneNumber, double depositAmount) {
        return riderRepository.payedDeposit(phoneNumber, depositAmount) > 0;
    }

    public Page<Rider> searchRiderForMixiConsole(RiderSerchParam riderSerchParam) {
        return riderRepository.findAll((Specification<Rider>) (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (!StringUtils.isEmpty(riderSerchParam.getName())) {
                predicates.add(criteriaBuilder.like(root.get("name"), "%" + riderSerchParam.getName() + "%"));
            }
            if (!ObjectUtils.isEmpty(riderSerchParam.getJobTitle())) {
                predicates.add(criteriaBuilder.equal(root.get("jobTitle"), riderSerchParam.getJobTitle()));
            }
            if (!ObjectUtils.isEmpty(riderSerchParam.getApprovalStatus())) {
                predicates.add(criteriaBuilder.equal(root.get("approvalStatus"), riderSerchParam.getApprovalStatus()));
            }

            query.where(criteriaBuilder.and(predicates.toArray(new Predicate[0])));
            return query.getRestriction();
        }, PageRequest.of(riderSerchParam.getPageNumber(), riderSerchParam.getPageSize()));
    }

    public boolean deleteRider(long id) {
        riderRepository.deleteById(id);
        return true;
    }

    public Page<Rider> getRiderByStationId(long stationId, int pageNumber, int pageSize) {
        return riderRepository.findAll((Specification<Rider>) (root, query, criteriaBuilder) -> {
            Predicate[] predicates = new Predicate[]{
                    criteriaBuilder.equal(root.get("station"), stationId),
                    criteriaBuilder.equal(root.get("isStartWorking"), true)
            };
            query.where(criteriaBuilder.and(predicates));
            return query.getRestriction();
        }, PageRequest.of(pageNumber, pageSize));
    }
}