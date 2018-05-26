package com.lecotec.mixi.repository;

import com.lecotec.mixi.model.entity.MerchantUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface MerchantUserRepository extends JpaRepository<MerchantUser, Long> {

    @Modifying
    @Transactional
    @Query("update MerchantUser t set t.password = :newPassword where t.phoneNumber=:phoneNumber and t.id <> 0")
    int updateMerchantPassword(@Param("phoneNumber") String phoneNumber, @Param("newPassword") String newPassword);

    MerchantUser findByPhoneNumber(String phoneNumber);
}
