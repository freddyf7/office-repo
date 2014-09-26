package com.freddy.training.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.freddy.training.model.Customer;
import com.freddy.training.model.Product;
import com.freddy.training.service.CustomerService;
import com.freddy.training.service.ProductService;

@Component("customerBean")
@Scope("request")
public class CustomerBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Autowired
    private CustomerService customerService;

    private Customer customer;

    private List<Customer> customerList;

    private int customerDelete;

    @PostConstruct
    public void init() {
    	customer = new Customer();

    	customerList = customerService.getAllCustomers();
    }

    /*Test*/
    public void saveCustomer(){
        Customer newCustomer = new Customer();
        newCustomer.setAddress(this.customer.getAddress());
        newCustomer.setName(this.customer.getName());
        newCustomer.setTelephone(this.customer.getTelephone());
        newCustomer.setBirthday(this.customer.getBirthday());

        customerService.addCustomer(newCustomer);
    }

    public void deleteCustomer(){
        customerService.removeCustomer(this.customer.getIdCustomer());
        customerList.remove(customer);
    }

    /*public void updateCustomer(){
        customerService.updateCustomer(customer);
    }*/

	public CustomerService getCustomerService() {
		return customerService;
	}

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<Customer> getCustomerList() {
		return customerList;
	}

	public void setCustomerList(List<Customer> customerList) {
		this.customerList = customerList;
	}

	public int getCustomerDelete() {
		return customerDelete;
	}

	public void setCustomerDelete(int customerDelete) {
		this.customerDelete = customerDelete;
	}





}
