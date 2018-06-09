package com.lecotec.mixi.service;

import com.lecotec.mixi.model.entity.SendCost;
import com.lecotec.mixi.repository.SendCostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SendCostService {
    @Autowired
    private SendCostRepository sendCostRepository;


    public List<SendCost> getSendCost() {
        return sendCostRepository.findAll();
    }

    public SendCost saveOrUpdate(SendCost sendCost) {
        return sendCostRepository.save(sendCost);
    }
}
