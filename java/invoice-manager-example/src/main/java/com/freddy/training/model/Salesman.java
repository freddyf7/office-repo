package com.freddy.training.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Salesman")
public class Salesman {

    @Id
    @Column(name = "idSalesman")
    @GeneratedValue
    private int idSalesman;

    @Column(name = "name")
    private String name;

    @Column(name = "telephone")
    private String telephone;

    /**
     * @return the idSalesman
     */
    public int getIdSalesman() {
        return idSalesman;
    }

    /**
     * @param idSalesman the idSalesman to set
     */
    public void setIdSalesman(int idSalesman) {
        this.idSalesman = idSalesman;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the telephone
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * @param telephone the telephone to set
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

}
