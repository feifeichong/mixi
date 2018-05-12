package com.lecotec.mixi.service;

import com.lecotec.mixi.model.entity.RiderBankAccount;
import com.lecotec.mixi.repository.RiderBankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RiderBankAccountService {
    @Autowired
    private RiderBankAccountRepository riderBankAccountRepository;

    public RiderBankAccount saveRiderBankAccount(RiderBankAccount riderBankAccount) {
        return riderBankAccountRepository.save(riderBankAccount);
    }

    public boolean deleteRiderBankAccount(long riderBankAccountId) {
        return riderBankAccountRepository.deleteRiderBankAccount(riderBankAccountId) > 0;
    }
}
