package com.tahmid.springcrud.service;

import com.tahmid.springcrud.Entity.Customer;

import java.util.List;

/**
 * @author Tahmidul Islam
 */
public interface CustomerService {
    public List<Customer> getCustomers();

    public void saveCustomer(Customer theCustomer);


    public Customer getCustomer(int theId);

    void deleteCustomer(int theId);
}
