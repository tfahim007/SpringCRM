package com.tahmid.springcrud.service;

import com.tahmid.springcrud.Entity.Customer;
import com.tahmid.springcrud.dao.CustomerDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Tahmidul Islam
 */
@Service
public class CustomerServiceImplementation implements CustomerService{
    @Autowired
    private CustomerDAO customerDAO;

    @Override
    @Transactional
    public List<Customer> getCustomers() {
        return customerDAO.getCustomers();
    }
}