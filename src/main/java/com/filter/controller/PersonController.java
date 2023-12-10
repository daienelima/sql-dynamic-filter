package com.filter.controller;

import com.filter.exceptions.BadRequestException;
import com.filter.model.Error;
import com.filter.model.Person;
import com.filter.repository.PersonCustomRepositoryImpl;
import com.filter.service.PersonService;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.QueryValue;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Map;

@Controller
@Transactional
public class PersonController {
    private final PersonService service;
    private final PersonCustomRepositoryImpl repository;
    @Inject
    public PersonController(PersonService service, PersonCustomRepositoryImpl repository) {
        this.service = service;
        this.repository = repository;
    }

    @Get("/{?values*}")
    public HttpResponse<List<Person>> getAllPerson(@Nullable @QueryValue("values") Map<String, String> values) {
       try{
           return HttpResponse.ok(service.getAllByFilter(values));
       }catch (Exception e){
           var error = Error.builder().error("Error").details(e.getMessage()).build();
           throw new BadRequestException(error, e);
       }
    }

    private void getParams(Map<String, String> values){
        for(Map.Entry<String, String> value : values.entrySet()){
            System.out.println("Key: " + value.getKey() + " Value: " + value.getValue());
        }
    }

}
