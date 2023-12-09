package com.filter.model;

import com.fasterxml.jackson.annotation.JsonClassDescription;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "Person")
@JsonClassDescription
@NoArgsConstructor
@AllArgsConstructor
public class Person implements Serializable {
    @Id
    @Column(name = "id")
    private String id;
    @Column(name = "nick")
    private String nick;
    @Column(name = "birthday")
    private String birthday;
    @Column(name = "name")
    private String name;
    @Column(name = "stack")
    private String stack;
}
