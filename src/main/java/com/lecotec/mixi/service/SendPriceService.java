package com.lecotec.mixi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lecotec.mixi.model.entity.SendPrice;
import com.lecotec.mixi.repository.SendPriceRepository;

@Service
public class SendPriceService {

	@Autowired
	private SendPriceRepository sendPriceRepository;
	
	public SendPrice saveSendPrice(SendPrice sendPrice) {
		return sendPriceRepository.save(sendPrice);
	}
	
	public boolean updateSendPrice(double startingPrices, double sendPrices, String sendScope) {
		return sendPriceRepository.updateSendPrice(startingPrices, sendPrices, sendScope) > 0;
	}
}
