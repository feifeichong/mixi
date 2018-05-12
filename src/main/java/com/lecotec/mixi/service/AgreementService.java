package com.lecotec.mixi.service;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import com.lecotec.mixi.model.entity.Agreement;
import com.lecotec.mixi.repository.AgreementReponsitory;

@Service
public class AgreementService {

	@Autowired
	private AgreementReponsitory agreementReponsitory;
	
	public Agreement saveAgreement(Agreement agreement) {
		return agreementReponsitory.save(agreement);
	}
}
