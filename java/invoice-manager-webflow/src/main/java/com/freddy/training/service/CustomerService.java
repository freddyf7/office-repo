package com.freddy.training.service;

import java.util.List;

import com.freddy.training.model.Customer;

public interface CustomerService {

    public void addCustomer(Customer customer);

    public List<Customer> getAllCustomers();

    public Customer getCustomer(int idCustomer);

    public void removeCustomer(int idCustomer);

	void updateCustomer(Customer customer);
}
