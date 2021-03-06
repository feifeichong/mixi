package com.lecotec.mixi.service;

import com.lecotec.mixi.model.entity.Merchant;
import com.lecotec.mixi.repository.MerchantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MerchantService {

    @Autowired
    private MerchantRepository merchantRepository;

    public Merchant findByPhoneNumber(String phoneNumber) {
        return merchantRepository.findByPhoneNumber(phoneNumber);
    }

    public boolean updateMerchantPassword(String phoneNumber, String newPassword) {
        return merchantRepository.updateMerchantPassword(phoneNumber, newPassword) > 0;
    }

    public Merchant saveMerchant(Merchant merchant) {
        return merchantRepository.save(merchant);
    }
}
