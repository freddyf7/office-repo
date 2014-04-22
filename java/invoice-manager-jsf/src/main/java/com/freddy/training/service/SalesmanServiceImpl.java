package com.freddy.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.freddy.training.dao.SalesmanDAO;
import com.freddy.training.model.Salesman;

@Service
public class SalesmanServiceImpl implements SalesmanService {

    @Autowired
    private SalesmanDAO salesmanDao;

    @Transactional
    public void addSalesman(Salesman salesman) {
        salesmanDao.addSalesman(salesman);
    }

    @Transactional
    public List<Salesman> getAllSalesman() {
        return salesmanDao.getAllSalesman();
    }

    @Transactional
    public Salesman getSalesman(int idSalesman) {
        return salesmanDao.getSalesman(idSalesman);
    }

    @Transactional
    public void removeSalesman(int idSalesman) {
        salesmanDao.removeSalesman(idSalesman);
    }

}
