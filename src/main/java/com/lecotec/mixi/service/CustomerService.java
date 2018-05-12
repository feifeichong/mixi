package com.lecotec.mixi.service;

import com.lecotec.mixi.model.entity.Customer;
import com.lecotec.mixi.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer findByPhoneNumber(String phoneNumber) {
        return customerRepository.findByPhoneNumber(phoneNumber);
    }

    public boolean updateCustomerPassword(String phoneNumber, String newPassword) {
        return customerRepository.updateCustomerPassword(phoneNumber, newPassword) > 0;
    }
}
