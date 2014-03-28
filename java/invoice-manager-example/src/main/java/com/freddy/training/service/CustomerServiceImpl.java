package com.freddy.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.freddy.training.dao.CustomerDAO;
import com.freddy.training.model.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDAO customerDao;

    @Override
    public void addCustomer(Customer customer) {
        customerDao.addCustomer(customer);

    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerDao.getAllCustomers();
    }

    @Override
    public Customer getCustomer(int idCustomer) {
        return customerDao.getCustomer(idCustomer);
    }

    @Override
    public void removeCustomer(int idCustomer) {
        customerDao.removeCustomer(idCustomer);
    }
}
