package com.freddy.training.dao;

import java.util.List;

import com.freddy.training.model.Salesman;

public interface SalesmanDAO {

    public void addSalesman(Salesman salesman);

    public List<Salesman> getAllSalesman();

    public Salesman getSalesman(int idSalesman);

    public void removeSalesman(int idSalesman);

}
