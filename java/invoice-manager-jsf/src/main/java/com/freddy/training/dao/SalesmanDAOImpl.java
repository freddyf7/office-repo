package com.freddy.training.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.freddy.training.model.Salesman;

@Repository
public class SalesmanDAOImpl implements SalesmanDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void addSalesman(Salesman salesman) {
        sessionFactory.getCurrentSession().save(salesman);
    }

    @Override
    public List<Salesman> getAllSalesman() {
        return sessionFactory.getCurrentSession().createQuery("from Salesman").list();
    }

    @Override
    public Salesman getSalesman(int idSalesman) {
        Salesman salesman = (Salesman) sessionFactory.getCurrentSession().load(Salesman.class, idSalesman);

        return salesman;
    }

    @Override
    public void removeSalesman(int idSalesman) {
        Salesman salesman = (Salesman) sessionFactory.getCurrentSession().load(Salesman.class, idSalesman);

        if (salesman != null) {
            sessionFactory.getCurrentSession().delete(salesman);
        }
    }

}
