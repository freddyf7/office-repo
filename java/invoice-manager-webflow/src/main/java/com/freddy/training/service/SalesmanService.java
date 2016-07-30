package com.freddy.training.service;

import java.util.List;

import com.freddy.training.model.Salesman;

public interface SalesmanService {

    public void addSalesman(Salesman salesman);

    public List<Salesman> getAllSalesman();

    public Salesman getSalesman(int idSalesman);

    public void removeSalesman(int idSalesman);
}
