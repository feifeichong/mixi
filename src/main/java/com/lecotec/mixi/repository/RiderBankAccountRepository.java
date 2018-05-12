package com.lecotec.mixi.repository;

import com.lecotec.mixi.model.entity.RiderBankAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface RiderBankAccountRepository extends JpaRepository<RiderBankAccount, Long> {
    @Modifying
    @Transactional
    @Query("delete from RiderBankAccount where id=:riderBankAccountId")
    int deleteRiderBankAccount(@Param("riderBankAccountId") long riderBankAccountId);
}
