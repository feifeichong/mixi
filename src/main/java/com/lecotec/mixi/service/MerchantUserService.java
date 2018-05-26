package com.lecotec.mixi.service;

import com.lecotec.mixi.model.entity.MerchantUser;
import com.lecotec.mixi.repository.MerchantUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class MerchantUserService {

    @Autowired
    private MerchantUserRepository merchantUserRepository;

    public MerchantUser findByPhoneNumber(String phoneNumber) {
        return merchantUserRepository.findByPhoneNumber(phoneNumber);
    }

    public boolean updateMerchantUserPassword(String phoneNumber, String newPassword) {
        return merchantUserRepository.updateMerchantUserPassword(phoneNumber, newPassword) > 0;
    }

    public MerchantUser saveOrUpdateMerchantUser(MerchantUser merchant) {
        return merchantUserRepository.save(merchant);
    }

    public Page<MerchantUser> getMerchantUsers(int pageNumber, int pageSize) {
        return merchantUserRepository.findAll(PageRequest.of(pageNumber, pageSize));
    }

    public boolean deleteMerchantUser(long id) {
        merchantUserRepository.deleteById(id);
        return true;
    }
}
