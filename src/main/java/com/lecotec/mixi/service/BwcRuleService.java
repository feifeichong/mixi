package com.lecotec.mixi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lecotec.mixi.model.entity.BwcRule;
import com.lecotec.mixi.repository.BwcRuleReponsitory;

@Service
public class BwcRuleService {

	@Autowired
	private BwcRuleReponsitory bwcRuleReponsitory;
	
	public BwcRule saveBwcRule(BwcRule bwcRule) {
		return bwcRuleReponsitory.save(bwcRule);
	}
	
	public boolean updateBwcRule(long id, int zmScore, int rePayDays) {
		return bwcRuleReponsitory.updateBwcRule(id, zmScore, rePayDays) > 0;
	}
}
