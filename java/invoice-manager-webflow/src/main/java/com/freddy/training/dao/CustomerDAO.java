package com.freddy.training.dao;

import java.util.List;

import com.freddy.training.model.Customer;

public interface CustomerDAO {

    public void addCustomer(Customer customer);

    public List<Customer> getAllCustomers();

    public Customer getCustomer(int idCustomer);

    public void removeCustomer(int idCustomer);

	void updateCustomer(Customer customer);
}
