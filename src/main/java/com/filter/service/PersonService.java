package com.filter.service;

import com.filter.exceptions.BadRequestException;
import com.filter.model.Error;
import com.filter.model.Person;
import com.filter.repository.PersonRepository;
import io.micronaut.data.jpa.repository.criteria.Specification;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import jakarta.persistence.criteria.Predicate;
import jakarta.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Singleton
@Transactional
public class PersonService {
    private final PersonRepository repository;

    @Inject
    public PersonService(PersonRepository repository) {
        this.repository = repository;
    }

    public List<Person> getAllByFilter(Map<String, String> values){
        return repository.findAll(getAllByFilters(values));
    }
    private Specification<Person> getAllByFilters(Map<String, String> values){
        try{
            if(values.containsKey("birthday")){
                return (root, query, criteriaBuilder) -> {
                    //set prioridade em um filtro
                    return criteriaBuilder.greaterThanOrEqualTo(root.get("birthday"), values.get("birthday"));
                };
            }else {
                List<Predicate> predicates = new ArrayList<>();
                return (root, query, criteriaBuilder) -> {
                    for(Map.Entry<String, String> value : values.entrySet()){
                        var equal = criteriaBuilder.equal(root.get(value.getKey()), value.getValue());
                        predicates.add(equal);
                    }
                    return criteriaBuilder.or(predicates.toArray(Predicate[]::new));
                };
            }
        }catch (Exception e){
            var error = Error.builder().error("Error").details(e.getMessage()).build();
            throw new BadRequestException(error, e);
        }
    }
}
