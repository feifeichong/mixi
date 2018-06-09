package com.lecotec.mixi.service;

import com.lecotec.mixi.model.entity.SendCostRule;
import com.lecotec.mixi.repository.SendCostRuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SendCostRuleService {
    @Autowired
    private SendCostRuleRepository sendCostRuleRepository;

    public List<SendCostRule> findAll() {
        return sendCostRuleRepository.findAll();
    }

    @Transactional
    public void saveOrUpdate(List<SendCostRule> sendCostRules) {
        sendCostRuleRepository.deleteAll();
        sendCostRuleRepository.saveAll(sendCostRules);
    }
}
