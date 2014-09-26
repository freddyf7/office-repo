package com.freddy.training.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.freddy.training.model.Invoice;

@Repository
public class InvoiceDAOImpl implements InvoiceDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void addInvoice(Invoice invoice) {
        sessionFactory.getCurrentSession().persist(invoice);
    }

    @Override
    public List<Invoice> getAllInvoices() {
        return sessionFactory.getCurrentSession().createQuery("from Invoice").list();
    }

    @Override
    public Invoice getInvoice(int idInvoice) {
        Invoice invoice = (Invoice) sessionFactory.getCurrentSession().load(Invoice.class, idInvoice);

        return invoice;
    }

    @Override
    public void removeInvoice(int idInvoice) {
        Invoice invoice = (Invoice) sessionFactory.getCurrentSession().load(Invoice.class, idInvoice);

        if (invoice != null) {
            sessionFactory.getCurrentSession().delete(invoice);
        }
    }
}
