package com.tahmid.springcrud.dao;

import com.tahmid.springcrud.Entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author Tahmidul Islam
 */
@Repository
public class CustomerDAOImplementation implements CustomerDAO{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Customer> getCustomers() {
        Session currentSession = sessionFactory.getCurrentSession();

//        Query<Customer> theQuery = currentSession.createQuery("from Customer ",Customer.class);
        Query<Customer> theQuery = currentSession.createQuery("from Customer ");
        List<Customer> customers = theQuery.getResultList();
        return customers;
    }

    @Override
    public void saveCustomer(Customer theCustomer) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.save(theCustomer);
    }
}







