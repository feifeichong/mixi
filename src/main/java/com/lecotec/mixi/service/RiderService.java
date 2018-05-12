package com.lecotec.mixi.service;

import com.lecotec.mixi.model.entity.Rider;
import com.lecotec.mixi.repository.RiderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RiderService {
    @Autowired
    private RiderRepository riderRepository;

    public Rider findByPhoneNumber(String phoneNumber) {
        return riderRepository.findByPhoneNumber(phoneNumber);
    }

    public Rider saveRider(Rider rider) {
        return riderRepository.save(rider);
    }

    public boolean updateRiderPassword(String phoneNumber, String newPassword) {
        return riderRepository.updateRiderPassword(phoneNumber, newPassword) > 0;
    }

    public boolean payedDeposit(String phoneNumber, double depositAmount) {
        return riderRepository.payedDeposit(phoneNumber, depositAmount) > 0;
    }
}
