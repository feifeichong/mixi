package com.lecotec.mixi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lecotec.mixi.model.entity.Ordering;
import com.lecotec.mixi.repository.OrderingRepository;

@Service
public class OrderingService {

	@Autowired
	private OrderingRepository orderingRepository;
	
	public List<Ordering> batchSaveOrdering(List<Ordering> orderings) {
		return orderingRepository.saveAll(orderings);
	}
}
