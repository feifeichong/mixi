package com.lecotec.mixi.service;

import com.lecotec.mixi.model.entity.MerchantUserType;
import com.lecotec.mixi.repository.MerchantUserTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class MerchantUserTypeService {
    @Autowired
    private MerchantUserTypeRepository merchantUserTypeRepository;

    public MerchantUserType saveOrUpdate(MerchantUserType merchantUserType) {
        return merchantUserTypeRepository.save(merchantUserType);
    }

    public Page<MerchantUserType> getAllByPage(int pageNumber, int pageSize) {
        return merchantUserTypeRepository.findAll(PageRequest.of(pageNumber, pageSize));
    }

    public boolean delete(long id) {
        merchantUserTypeRepository.deleteById(id);
        return true;
    }
}
