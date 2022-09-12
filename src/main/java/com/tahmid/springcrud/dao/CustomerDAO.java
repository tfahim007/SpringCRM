package com.tahmid.springcrud.dao;

import com.tahmid.springcrud.Entity.Customer;

import java.util.List;

/**
 * @author Tahmidul Islam
 */
public interface CustomerDAO {
    public List<Customer> getCustomers();

    public void saveCustomer(Customer theCustomer);

    public Customer getCustomer(int theId);
}
