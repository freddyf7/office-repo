package com.freddy.training.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.freddy.training.model.Customer;
import com.freddy.training.model.Invoice;
import com.freddy.training.model.Item;
import com.freddy.training.model.Product;
import com.freddy.training.model.Salesman;
import com.freddy.training.service.CustomerService;
import com.freddy.training.service.InvoiceService;
import com.freddy.training.service.ProductService;
import com.freddy.training.webapp.AddedItem;

@Component("invoiceBean")
@Scope("request")
public class InvoiceBean implements Serializable {

    private static final long serialVersionUID = 1L;

    static final Logger logger = Logger.getLogger(InvoiceBean.class);

    @Autowired
    private InvoiceService invoiceService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private ProductService productService;

    private Invoice invoice;

    private List<Invoice> invoiceList;

    private Item newItem;

    private List<Item> addedItems;

    //private int customerDelete;

    @PostConstruct
    public void init() {
    	logger.info("Testing log4j!!!");

    	invoice = new Invoice();
    	newItem = new Item();
    	invoice.setCustomer(new Customer());
    	invoice.setSalesman(new Salesman());
    	newItem.setProduct(new Product());
    	addedItems = new ArrayList<Item>();

    	invoiceList = invoiceService.getAllInvoices();
    }

    /*Test*/
    public void saveInvoice(){
        Invoice newInvoice = new Invoice();
        newInvoice.setDate(this.invoice.getDate());
        newInvoice.setCustomer(this.invoice.getCustomer());
        newInvoice.setSalesman(this.invoice.getSalesman());
        newInvoice.getSalesman().setIdSalesman(1);

        //List<Item> items = new ArrayList<Item>();
        //newItem.setInvoice(newInvoice);
        //items.add(newItem);
        newInvoice.setItems(addedItems);

        invoiceService.addInvoice(newInvoice);
    }

    public void addItem(){
    	addedItems.add(newItem);
    }

    public List<Customer> getAvailableCustomers(){
    	return customerService.getAllCustomers();
    }

    public List<Product> getAvailableProducts(){
    	return productService.getAllProducts();
    }

	public InvoiceService getInvoiceService() {
		return invoiceService;
	}

	public void setInvoiceService(InvoiceService invoiceService) {
		this.invoiceService = invoiceService;
	}

	public Invoice getInvoice() {
		return invoice;
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}

	public List<Invoice> getInvoiceList() {
		return invoiceList;
	}

	public void setInvoiceList(List<Invoice> invoiceList) {
		this.invoiceList = invoiceList;
	}

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	public Item getNewItem() {
		return newItem;
	}

	public void setNewItem(Item newItem) {
		this.newItem = newItem;
	}

	public ProductService getProductService() {
		return productService;
	}

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	public List<Item> getAddedItems() {
		return addedItems;
	}

	public void setAddedItems(List<Item> addedItems) {
		this.addedItems = addedItems;
	}



    /*public void deleteInvoice(){
        customerService.removeCustomer(this.customer.getIdCustomer());
        customerList.remove(customer);
    }*/

    /*public void updateCustomer(){
        customerService.updateCustomer(customer);
    }*/


}
