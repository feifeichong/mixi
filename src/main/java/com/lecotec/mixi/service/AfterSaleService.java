package com.lecotec.mixi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lecotec.mixi.model.entity.AfterSale;
import com.lecotec.mixi.repository.AfterSaleRepository;

@Service
public class AfterSaleService {

	@Autowired
	private AfterSaleRepository afterSaleRepository;
	
	public AfterSale saveAfterSale(AfterSale afterSale) {
		return afterSaleRepository.save(afterSale);
	};
}
