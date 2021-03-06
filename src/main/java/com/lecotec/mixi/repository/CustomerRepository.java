package com.lecotec.mixi.repository;

import com.lecotec.mixi.model.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Customer findByPhoneNumber(String phoneNumber);

    @Modifying
    @Transactional
    @Query("update Customer t set t.password=:newPassword where t.phoneNumber=:phoneNumber and t.id <> ''")
    int updateCustomerPassword(@Param("phoneNumber") String phoneNumber, @Param("newPassword") String newPassword);
}
