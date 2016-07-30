package com.freddy.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.freddy.training.dao.InvoiceDAO;
import com.freddy.training.model.Invoice;

@Service
public class InvoiceServiceImpl implements InvoiceService {

    @Autowired
    private InvoiceDAO invoiceDao;

    @Transactional
    public void addInvoice(Invoice invoice) {
        invoiceDao.addInvoice(invoice);
    }

    @Transactional
    public List<Invoice> getAllInvoices() {
        return invoiceDao.getAllInvoices();
    }

    @Transactional
    public Invoice getInvoice(int idInvoice) {
        return invoiceDao.getInvoice(idInvoice);
    }

    @Transactional
    public void removeInvoice(int idInvoice) {
        invoiceDao.removeInvoice(idInvoice);
    }

}
