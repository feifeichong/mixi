package com.lecotec.mixi.repository;

import com.lecotec.mixi.model.entity.Rider;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface RiderRepository extends JpaRepository<Rider, Long>, JpaSpecificationExecutor<Rider> {
    Rider findByPhoneNumber(String phoneNumber);

    @Modifying
    @Transactional
    @Query("update Rider t set t.password=:newPassword where t.phoneNumber=:phoneNumber and t.id <> ''")
    int updateRiderPassword(@Param("phoneNumber") String phoneNumber, @Param("newPassword") String newPassword);

    @Modifying
    @Transactional
    @Query("update Rider t set t.depositAmount=:depositAmount, t.hasPaidDeposit=true where t.phoneNumber=:phoneNumber and t.id <> ''")
    int payedDeposit(@Param("phoneNumber") String phoneNumber, @Param("depositAmount") double depositAmount);

    @Transactional
    @Modifying
    @Query("update Rider t set t.isActive = :isActive where t.id = :id")
    int changeActiveStatus(@Param("id") long id, @Param("isActive") boolean isActive);
}
