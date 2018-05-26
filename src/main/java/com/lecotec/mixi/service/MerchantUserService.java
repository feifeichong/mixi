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

    public boolean updateMerchantPassword(String phoneNumber, String newPassword) {
        return merchantUserRepository.updateMerchantPassword(phoneNumber, newPassword) > 0;
    }

    public MerchantUser saveMerchant(MerchantUser merchant) {
        return merchantUserRepository.save(merchant);
    }

    public Page<MerchantUser> getMerchants(int pageNumber, int pageSize) {
        return merchantUserRepository.findAll(PageRequest.of(pageNumber, pageSize));
    }

    public boolean deleteMerchant(long id) {
        merchantUserRepository.deleteById(id);
        return true;
    }
}
