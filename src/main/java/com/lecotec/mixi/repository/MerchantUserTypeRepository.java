package com.lecotec.mixi.repository;

import com.lecotec.mixi.model.entity.MerchantUserType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MerchantUserTypeRepository extends JpaRepository<MerchantUserType, Long>, JpaSpecificationExecutor<MerchantUserType> {
}
