package com.freddy.training.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Invoice")
public class Invoice {

    @Id
    @Column(name = "idInvoice")
    @GeneratedValue
    private int idInvoice;

    @Column(name = "date")
    private Date date;

    @Column(name = "total")
    private BigDecimal total;

    @ManyToOne
    @JoinColumn(name = "idCustomer")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "idSalesman")
    private Salesman salesman;

    /**
     * @return the idInvoice
     */
    public int getIdInvoice() {
        return idInvoice;
    }

    /**
     * @param idInvoice the idInvoice to set
     */
    public void setIdInvoice(int idInvoice) {
        this.idInvoice = idInvoice;
    }

    /**
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * @return the total
     */
    public BigDecimal getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    /**
     * @return the customer
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * @param customer the customer to set
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    /**
     * @return the salesman
     */
    public Salesman getSalesman() {
        return salesman;
    }

    /**
     * @param salesman the salesman to set
     */
    public void setSalesman(Salesman salesman) {
        this.salesman = salesman;
    }

}
