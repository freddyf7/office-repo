package com.freddy.training.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.freddy.training.model.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addCustomer(Customer customer) {
        sessionFactory.getCurrentSession().save(customer);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return sessionFactory.getCurrentSession().createQuery("from Customer").list();
    }

    @Override
    public Customer getCustomer(int idCustomer) {
        Customer customer = (Customer) sessionFactory.getCurrentSession().load(Customer.class, idCustomer);

        return customer;
    }

    @Override
    public void removeCustomer(int idCustomer) {
        Customer customer = (Customer) sessionFactory.getCurrentSession().load(Customer.class, idCustomer);

        if (customer != null) {
            sessionFactory.getCurrentSession().delete(customer);
        }

    }
}
