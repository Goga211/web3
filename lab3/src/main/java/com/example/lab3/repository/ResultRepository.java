package com.example.lab3.repository;

import com.example.lab3.model.Result;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class ResultRepository {

    public void save(Result result) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(result);
        em.getTransaction().commit();
        em.close();
    }

    public List<Result> findAll() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();
        List<Result> results = em.createQuery("SELECT r FROM Result r", Result.class).getResultList();
        em.close();
        return results;
    }

}
