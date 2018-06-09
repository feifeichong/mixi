package com.lecotec.mixi.service;

import com.lecotec.mixi.model.entity.MerchantUser;
import com.lecotec.mixi.repository.MerchantUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MerchantUserService {

    @Autowired
    private MerchantUserRepository merchantUserRepository;

    public MerchantUser findByAccount(String phoneNumber) {
        return merchantUserRepository.findByAccount(phoneNumber);
    }

    public boolean updatePassword(String phoneNumber, String newPassword) {
        return merchantUserRepository.updateMerchantUserPassword(phoneNumber, newPassword) > 0;
    }

    public MerchantUser saveOrUpdate(MerchantUser merchant) {
        return merchantUserRepository.save(merchant);
    }

    public Page<MerchantUser> getMerchantUsers(int pageNumber, int pageSize) {
        return merchantUserRepository.findAll(PageRequest.of(pageNumber, pageSize));
    }

    public boolean delete(long id) {
        merchantUserRepository.deleteById(id);
        return true;
    }

    public boolean changeActiveStatus(long id, boolean isActive) {
        return merchantUserRepository.changeActiveStatus(id, isActive) > 0;
    }

    public boolean isExistUserByUserTypeId(long userTypeId) {
        return merchantUserRepository.findByMerchantUserTypeId(userTypeId).size() > 0;
    }
}
