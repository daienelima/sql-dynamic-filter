package com.filter.repository;

import com.filter.model.Person;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.jpa.repository.JpaRepository;
import io.micronaut.data.jpa.repository.JpaSpecificationExecutor;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface PersonRepository extends JpaRepository<Person, String>, JpaSpecificationExecutor<Person> {

}
