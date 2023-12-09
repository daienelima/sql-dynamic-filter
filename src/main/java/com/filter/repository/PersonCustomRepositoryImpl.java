package com.filter.repository;

import com.filter.model.Person;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

import java.util.List;

@Transactional
public class PersonCustomRepositoryImpl {
    private final EntityManager entityManager;

    @Inject
    public PersonCustomRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Person> findAllByFilter(String name, String nick) {
        var query = "SELECT p from Person p WHERE 1 = 1 ";
        if(name != null){
            query += "and p.name = :name";
        }
        var result = entityManager.createQuery(query, Person.class);

        if (name != null){
            result.setParameter("nome", name);
        }
        return result.getResultList();
    }
}
