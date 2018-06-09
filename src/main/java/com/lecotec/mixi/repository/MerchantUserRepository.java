package com.lecotec.mixi.repository;

import com.lecotec.mixi.model.entity.MerchantUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface MerchantUserRepository extends JpaRepository<MerchantUser, Long> {

    @Modifying
    @Transactional
    @Query("update MerchantUser t set t.password = :newPassword where t.account=:account and t.id <> 0")
    int updateMerchantUserPassword(@Param("account") String account, @Param("newPassword") String newPassword);

    MerchantUser findByAccount(String phoneNumber);

    @Modifying
    @Transactional
    @Query("update MerchantUser t set t.isActive = :isActive where t.id = :id")
    int changeActiveStatus(@Param("id") long id, @Param("isActive") boolean isActive);

    List<MerchantUser> findByMerchantUserTypeId(long userTypeId);
}
