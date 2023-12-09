package com.filter;

import com.filter.model.Person;
import io.micronaut.runtime.Micronaut;
import io.micronaut.serde.annotation.SerdeImport;

@SerdeImport(Person.class)
public class Application {

    public static void main(String[] args) {
        Micronaut.run(Application.class, args);
    }
}