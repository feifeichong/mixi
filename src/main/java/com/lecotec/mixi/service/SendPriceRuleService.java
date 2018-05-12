package com.lecotec.mixi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;

import com.lecotec.mixi.model.entity.SendPriceRule;
import com.lecotec.mixi.repository.SendPriceRuleRepository;

@Service
public class SendPriceRuleService {

	@Autowired
	private SendPriceRuleRepository sendPriceRepository;
	
	public SendPriceRule saveSendPriceRule(SendPriceRule sendPriceRule) {
		return sendPriceRepository.save(sendPriceRule);
	}
	
	public boolean updateSendPriceRule(long id, double minOrderPrice, double maxOrderPrice, double riderIncome) {
		return sendPriceRepository.updateSendPriceRule(id, minOrderPrice, maxOrderPrice, riderIncome) > 0;
	}
}
