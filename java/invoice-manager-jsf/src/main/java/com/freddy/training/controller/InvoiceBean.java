package com.freddy.training.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

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

@Component("invoiceBean")
@Scope("view")
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

    @PostConstruct
    public void init() {
    	logger.info("Testing log4j!!!");

    	refreshBean();
    	invoiceList = invoiceService.getAllInvoices();
    }

    private void refreshBean(){
    	addedItems = new ArrayList<Item>();
        invoice = new Invoice();
        newItem = new Item();
        invoice.setCustomer(new Customer());
    	invoice.setSalesman(new Salesman());
    	newItem.setProduct(new Product());
    }

    public String saveInvoice(){
    	invoice.setItems(addedItems);
    	invoice.getSalesman().setIdSalesman(1);
        invoiceService.addInvoice(invoice);
        refreshBean();

        return "";
    }

    public void addItem(){
    	Product addedProduct = productService.getProduct(newItem.getProduct().getIdProduct());
    	Item addedItem = new Item();
    	addedItem.setProduct(addedProduct);
    	addedItem.setPrice(addedProduct.getPrice());
    	addedItem.setQuantity(newItem.getQuantity());
    	addedItem.setInvoice(invoice);
    	addedItems.add(addedItem);
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


}
