package com.freddy.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.freddy.training.dao.CustomerDAO;
import com.freddy.training.model.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDAO customerDao;

    @Override
    @Transactional
    public void addCustomer(Customer customer) {
        customerDao.addCustomer(customer);
    }
    
    @Override
    @Transactional
    public void updateCustomer(Customer customer) {
        customerDao.updateCustomer(customer);

    }

    @Override
    @Transactional
    public List<Customer> getAllCustomers() {
        return customerDao.getAllCustomers();
    }

    @Override
    @Transactional
    public Customer getCustomer(int idCustomer) {
        return customerDao.getCustomer(idCustomer);
    }

    @Override
    @Transactional
    public void removeCustomer(int idCustomer) {
        customerDao.removeCustomer(idCustomer);
    }
    
    
}
