package com.freddy.training.dao;

import java.util.List;

import com.freddy.training.model.Invoice;

public interface InvoiceDAO {

    public void addInvoice(Invoice invoice);

    public List<Invoice> getAllInvoices();

    public Invoice getInvoice(int idInvoice);

    public void removeInvoice(int idInvoice);
}
